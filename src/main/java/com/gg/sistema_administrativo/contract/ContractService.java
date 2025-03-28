package com.gg.sistema_administrativo.contract;

import com.gg.sistema_administrativo.exception.EntityAlreadyExistsException;
import com.gg.sistema_administrativo.exception.EntityNotFoundException;
import com.gg.sistema_administrativo.exception.PropertyAlreadyInUseException;
import com.gg.sistema_administrativo.utils.Log;
import com.gg.sistema_administrativo.utils.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return contractRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontró el contrato ID -> " + id));
    }

    public List<Contract> getAllByName(String name){
        return contractRepository.findByNameContaining(name);
    }

    public Contract getByName(String name){
        return contractRepository.findByName(name).orElseThrow(()-> new EntityNotFoundException("No se encontró el usuario con nombre -> " + name));
    }

    public List<Contract> getByStatus(boolean status){
        return contractRepository.findByStatus(status);
    }

    public Contract add(ContractCreateDTO contractCreateDTO){
        if(contractRepository.existsByName(contractCreateDTO.getName())){
            throw new EntityAlreadyExistsException("El contrato " + contractCreateDTO.getName() + " ya existe");
        }
        Contract contract = contractRepository.save(new Contract(contractCreateDTO.getName()));
        logRepository.save(new Log("CONTRATO AGREGADO", "Se agregó el contrato con ID -> " + contract.getId(), 0));
        return contract;
    }

    public Contract update(long id, ContractUpdateDTO contractUpdateDTO){
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el contrato ID " + id));
        if(isNameUpdated(contract, contractUpdateDTO) || isStatusUpdated(contract, contractUpdateDTO) || isTotalExpensesUpdated(contract, contractUpdateDTO)){
            Contract savedContract = contractRepository.save(contract);
            logRepository.save(new Log("USUARIO ACTUALIZADO", "Se actualizó el usuario ID -> " + savedContract.getId(), 0));
            return savedContract;
        } else {
            return contract;
        }
    }
    public boolean isNameUpdated(Contract contract, ContractUpdateDTO contractUpdateDTO){
        String newName = contractUpdateDTO.getName();
        String oldName = contract.getName();
        if(!newName.equals(oldName)){
            if(contractRepository.existsByName(newName)){
                throw new PropertyAlreadyInUseException("El nombre '"+ newName + "' ya se encuentra en uso por otro contrato");
            } else{
                contract.setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean isStatusUpdated(Contract contract, ContractUpdateDTO contractUpdateDTo){
        if(contract.isStatus() != contractUpdateDTo.isStatus()){
            contract.setStatus(contractUpdateDTo.isStatus());
            return true;
        }
        return false;
    }

    public boolean isTotalExpensesUpdated(Contract contract, ContractUpdateDTO contractUpdateDTo){
        if(contract.getTotalExpenses() != contractUpdateDTo.getTotalExpenses()){
            contract.setTotalExpenses(contractUpdateDTo.getTotalExpenses());
            return true;
        }
        return false;
    }
}
