package com.gg.sistema_administrativo.service;

import com.gg.sistema_administrativo.dto.ContractCreateDTO;
import com.gg.sistema_administrativo.model.Contract;
import com.gg.sistema_administrativo.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    ContractRepository contractRepository;
    public List<Contract> getAll(){
        return contractRepository.findAll();
    }

    public Contract getById(long id){
        return contractRepository.findById(id).orElse(null);
    }

    public List<Contract> getAllByName(String name){
        return contractRepository.findByNameContaining(name);
    }

    public Optional<?> getByName(String name){
        return contractRepository.findByName(name);
    }

    public List<Contract> getByStatus(boolean status){
        return contractRepository.findByStatus(status);
    }

    public Contract add(ContractCreateDTO contractCreateDTO){
        if(contractRepository.findByName(contractCreateDTO.getName()).isPresent()){
            //En lugar de null debe lanzar excepcion por duplicado
            return null;
        }
        return contractRepository.save(new Contract(contractCreateDTO.getName()));
    }
}
