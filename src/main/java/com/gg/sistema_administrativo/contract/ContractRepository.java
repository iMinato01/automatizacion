package com.gg.sistema_administrativo.contract;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByNameContaining(String name);
    Optional<Contract> findByName(String name);
    boolean existsByName(String name);
    List<Contract> findByStatus(boolean status);
}
