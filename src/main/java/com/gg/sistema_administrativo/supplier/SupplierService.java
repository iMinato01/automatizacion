package com.gg.sistema_administrativo.supplier;

import com.gg.sistema_administrativo.contract.Contract;
import com.gg.sistema_administrativo.contract.ContractUpdateDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    public List<Supplier> getAll(){
        return null;
    }

    public Supplier getById(long id){
        return null;
    }

    public List<Supplier> getAllByName(String name){
        return null;
    }

    public Supplier getByName(String name){
        return null;
    }

    public List<Supplier> getByStatus(boolean status){
        return null;
    }

    public Supplier add(SupplierCreateDTO supplierCreateDTO){
        return null;
    }

    public Contract update(long id, ContractUpdateDTO contractUpdateDTO){
        return null;
    }
}
