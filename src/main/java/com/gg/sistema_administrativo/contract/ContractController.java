package com.gg.sistema_administrativo.contract;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;
    public ContractController(ContractService contractService){
        this.contractService = contractService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Contract>> getAll(){
            return ResponseEntity.status(200).body(contractService.getAll());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Contract> getById(@PathVariable long id){
        Contract contract = contractService.getById(id);
        return contract != null ? ResponseEntity.status(200).body(contract): ResponseEntity.status(404).build();
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
