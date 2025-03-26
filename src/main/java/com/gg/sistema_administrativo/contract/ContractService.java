package com.gg.sistema_administrativo.contract;

import com.gg.sistema_administrativo.exception.ContractAlreadyExistsException;
import com.gg.sistema_administrativo.exception.ContractNotFoundException;
import com.gg.sistema_administrativo.exception.PropertyAlreadyInUseException;
import com.gg.sistema_administrativo.utils.Log;
import com.gg.sistema_administrativo.utils.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final LogRepository logRepository;
    public ContractService(ContractRepository contractRepository, LogRepository logRepository){
        this.contractRepository = contractRepository;
        this.logRepository = logRepository;
    }
    public List<Contract> getAll(){
        return contractRepository.findAll();
    }

    public Contract getById(long id){
        return contractRepository.findById(id).orElseThrow(()-> new ContractNotFoundException("No se encontró el contrato ID -> " + id));
    }

    public List<Contract> getAllByName(String name){
        return contractRepository.findByNameContaining(name);
    }

    public Contract getByName(String name){
        return contractRepository.findByName(name).orElseThrow(()-> new ContractNotFoundException("No se encontró el usuario con nombre -> " + name));
    }

    public List<Contract> getByStatus(boolean status){
        return contractRepository.findByStatus(status);
    }

    public Contract add(ContractCreateDTO contractCreateDTO){
        if(contractRepository.findByName(contractCreateDTO.getName()).isPresent()){
            throw new ContractAlreadyExistsException("El contrato " + contractCreateDTO.getName() + " ya existe");
        }
        return contractRepository.save(new Contract(contractCreateDTO.getName()));
    }

    public Contract update(long id, ContractUpdateDTO contractUpdateDTO){
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException("No se encontró el contrato ID " + id));
        boolean updated = false;
        if(!contract.getName().equals(contractUpdateDTO.getName())){
            if(!contractRepository.findAllByName(contractUpdateDTO.getName()).isEmpty()) {
                throw new PropertyAlreadyInUseException("El nombre " + contractUpdateDTO.getName() + " ya está en uso por otro contrato");
            } else {
                contract.setName(contractUpdateDTO.getName());
                updated = true;
            }
        }
        if(contract.isStatus() != (contractUpdateDTO.isStatus())){
            contract.setStatus(contractUpdateDTO.isStatus());
            updated = true;
        }
        if(contract.getTotalExpenses() != contractUpdateDTO.getTotalExpenses()){
            contract.setTotalExpenses(contractUpdateDTO.getTotalExpenses());
            updated = true;
        }
        if(updated){
            Contract savedContract = contractRepository.save(contract);
            logRepository.save(new Log("USUARIO ACTUALIZADO", "Se actualizó el usuario ID -> " + savedContract.getId(), 0));
            return savedContract;
        } else {
            return contract;
        }
    }
}
