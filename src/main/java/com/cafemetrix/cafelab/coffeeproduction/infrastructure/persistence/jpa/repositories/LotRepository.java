package com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories;

import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.LotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotRepository extends JpaRepository<LotEntity, Long> {
    Optional<LotEntity> findByLotName(String lotName);
    List<LotEntity> findAllByUserId(Long userId);
    List<LotEntity> findAllBySupplierId(Long supplierId);
} 