package com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByUserId(Long userId);
} 