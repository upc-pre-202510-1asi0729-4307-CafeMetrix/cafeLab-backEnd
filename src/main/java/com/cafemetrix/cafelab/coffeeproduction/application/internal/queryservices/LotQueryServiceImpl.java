package com.cafemetrix.cafelab.coffeeproduction.application.internal.queryservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllLotsQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetLotByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetLotByNameQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetLotsBySupplierQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.LotQueryService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.LotEntity;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LotQueryServiceImpl implements LotQueryService {
    
    @Autowired
    private LotRepository lotRepository;

    @Override
    public List<Lot> getAllLots(GetAllLotsQuery query) {
        return lotRepository.findAllByUserId(query.userId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Lot> getLotByName(GetLotByNameQuery query) {
        return lotRepository.findByLotName(query.lotName())
                .map(this::toDomain);
    }

    @Override
    public Optional<Lot> getLotById(GetLotByIdQuery query) {
        return lotRepository.findById(query.lotId().value())
                .map(this::toDomain);
    }

    @Override
    public List<Lot> getLotsBySupplier(GetLotsBySupplierQuery query) {
        return lotRepository.findAllBySupplierId(query.supplierId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Lot toDomain(LotEntity entity) {
        return new Lot(
                new LotId(entity.getId()),
                new SupplierId(entity.getSupplierId()),
                new UserId(entity.getUserId()),
                new LotName(entity.getLotName()),
                new CoffeeType(entity.getCoffeeType()),
                new ProcessingMethod(entity.getProcessingMethod()),
                new Altitude(entity.getAltitude()),
                new Weight(entity.getWeight()),
                new Certifications(java.util.Arrays.asList(entity.getCertifications().split(","))),
                new Origin(entity.getOrigin()),
                entity.getStatus()
        );
    }
} 