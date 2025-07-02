package com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.repositories;

import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities.InventoryEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryEntryRepository extends JpaRepository<InventoryEntryEntity, Long> {
    List<InventoryEntryEntity> findAllByUserId(Long userId);
    List<InventoryEntryEntity> findAllByCoffeeLotId(Long coffeeLotId);
} 