package com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories;

import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.RoastProfileEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoastProfileRepository extends JpaRepository<RoastProfileEntity, Long> {
    Optional<RoastProfileEntity> findByName(String name);
    List<RoastProfileEntity> findAllByUserId(Long userId);
    List<RoastProfileEntity> findAllByUserId(Long userId, Sort sort);
    List<RoastProfileEntity> findAllByLot(Long lot);
    List<RoastProfileEntity> findAllByUserIdAndIsFavoriteTrue(Long userId);
} 