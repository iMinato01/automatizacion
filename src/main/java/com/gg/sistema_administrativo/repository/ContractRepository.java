package com.gg.sistema_administrativo.repository;

import com.gg.sistema_administrativo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByNameContaining(String name);
    Optional<?> findByName(String name);
    List<Contract> findByStatus(boolean status);
}
