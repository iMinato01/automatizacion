package com.gg.sistema_administrativo.supplier;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;
    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAll(){
        return ResponseEntity.status(200).body(supplierService.getAll());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable long id){
        Supplier supplier = supplierService.getById(id);
        return supplier != null ? ResponseEntity.status(200).body(supplier): ResponseEntity.status(404).build();
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Supplier>> getByName(@PathVariable String name){
        return ResponseEntity.status(200).body(supplierService.getAllByName(name));
    }

    @GetMapping("/byStatus/{status}")
    public ResponseEntity<List<Supplier>> getByStatus(@PathVariable boolean status){
        return ResponseEntity.ok(supplierService.getByStatus(status));
    }

    @PostMapping("/add")
    public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody SupplierCreateDTO supplierDTO){
        Supplier supplier = supplierService.add(supplierDTO);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable long id, @Valid @RequestBody SupplierUpdateDTO supplierUpdateDTO){
        Supplier supplier = supplierService.update(id, supplierUpdateDTO);
        return ResponseEntity.ok(supplier);
    }
}
