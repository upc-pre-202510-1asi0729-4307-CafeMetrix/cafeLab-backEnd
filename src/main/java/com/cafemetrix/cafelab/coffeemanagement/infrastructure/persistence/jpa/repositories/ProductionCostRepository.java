package com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.repositories;

import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities.ProductionCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionCostRepository extends JpaRepository<ProductionCostEntity, Long> {
    List<ProductionCostEntity> findAllByUserId(Long userId);
    List<ProductionCostEntity> findAllByCoffeeLotId(Long coffeeLotId);
}