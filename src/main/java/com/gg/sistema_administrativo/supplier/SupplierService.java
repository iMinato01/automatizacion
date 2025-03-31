package com.gg.sistema_administrativo.supplier;

import com.gg.sistema_administrativo.contract.Contract;
import com.gg.sistema_administrativo.contract.ContractUpdateDTO;

import com.gg.sistema_administrativo.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    public List<Supplier> getAllByValue(String value){
        return supplierRepository.findByValue(value);
    }

    public Supplier getById(long id){
        return supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el Proveedor ID -> " + id));
    }
    public Supplier getByName(String name){
        return supplierRepository.findByName(name).orElseThrow(()-> new EntityNotFoundException("No se encontró el Proveedor con nombre -> " + name));
    }

    public Supplier getByRfc(String rfc){
        return supplierRepository.findByRfc(rfc).orElseThrow(()-> new EntityNotFoundException("No se encontró el Proveedor con RFC -> " + rfc));
    }

    public Supplier getByEmail(String email){
        return supplierRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("No se encontró el proveedor con el correo -> " + email));
    }

    public Supplier getByPhoneNumber(String phoneNumber){
        return supplierRepository.findByPhoneNumber(phoneNumber).orElseThrow(()-> new EntityNotFoundException("No se encontró el Proveedor con número telefónico -> " + phoneNumber));
    }

    public List<Supplier> getAllByName(String name){
        return supplierRepository.findAllByName(name);
    }

    public List<Supplier> getAllByStatus(boolean status){
        return supplierRepository.findAllByStatus(status);
    }

    public Supplier add(SupplierCreateDTO supplierCreateDTO){
        return null;
    }

    public Contract update(long id, ContractUpdateDTO contractUpdateDTO){
        return null;
    }
}
