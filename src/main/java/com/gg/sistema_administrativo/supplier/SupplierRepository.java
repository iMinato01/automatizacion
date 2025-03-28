package com.gg.sistema_administrativo.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("SELECT e FROM Supplier e WHERE e.name LIKE %:value OR e.rfc LIKE %:value OR " +
            "e.email LIKE %:value OR e.phoneNumber LIKE %:value OR e.services LIKE %:value")
    List<Supplier> findByValue(@Param("value") String value);
    Optional<Supplier> findById(long id);
    Optional<Supplier> findByName(String name);
    Optional<Supplier> findByRfc(String rfc);
    Optional<Supplier> findByEmail(String email);
    Optional<Supplier> findByPhoneNumber(String phoneNumber);
    boolean existsByName(String name);
    boolean existsByRfc(String rfc);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    List<Supplier> findAllByStatus(boolean status);

}
