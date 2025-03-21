package com.gg.sistema_administrativo.controller;

import com.gg.sistema_administrativo.dto.ContractCreateDTO;
import com.gg.sistema_administrativo.dto.ContractUpdateDTO;
import com.gg.sistema_administrativo.model.Contract;
import com.gg.sistema_administrativo.service.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;
    @GetMapping("/all")
    public ResponseEntity<List<Contract>> getAll(){
            return ResponseEntity.status(200).body(contractService.getAll());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Contract> getById(@PathVariable long id){
        Contract contract = contractService.getById(id);
        if(contract != null){
            return ResponseEntity.status(200).body(contract);
        } else{
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Contract>> getByName(@PathVariable String name){
        return ResponseEntity.status(200).body(contractService.getAllByName(name));
    }

    @GetMapping("/byStatus/{status}")
    public ResponseEntity<List<Contract>> getByStatus(@PathVariable boolean status){
        return ResponseEntity.ok(contractService.getByStatus(status));
    }

    @PostMapping("/add")
    public ResponseEntity<Contract> addContract(@Valid @RequestBody ContractCreateDTO contractDTO){
        Contract contract = contractService.add(contractDTO);
            return ResponseEntity.ok(contract);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable long id, @Valid @RequestBody ContractUpdateDTO contractUpdateDTO){
        Contract contract = contractService.update(id, contractUpdateDTO);
        return ResponseEntity.ok(contract);
    }
}
