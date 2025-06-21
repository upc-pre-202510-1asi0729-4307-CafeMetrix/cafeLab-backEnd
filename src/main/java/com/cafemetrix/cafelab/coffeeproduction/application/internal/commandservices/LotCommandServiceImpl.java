package com.cafemetrix.cafelab.coffeeproduction.application.internal.commandservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.LotCommandService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.LotEntity;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotCommandServiceImpl implements LotCommandService {
    
    @Autowired
    private LotRepository lotRepository;

    @Override
    public Lot createLot(CreateLotCommand command) {
        LotEntity entity = new LotEntity();
        entity.setSupplierId(command.supplierId().value());
        entity.setUserId(command.userId().value());
        entity.setLotName(command.lotName());
        entity.setCoffeeType(command.coffeeType());
        entity.setProcessingMethod(command.processingMethod());
        entity.setAltitude(command.altitude());
        entity.setWeight(command.weight());
        entity.setCertifications(String.join(",", command.certifications()));
        entity.setOrigin(command.origin());
        
        LotEntity saved = lotRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Lot updateLot(UpdateLotCommand command) {
        LotEntity entity = lotRepository.findById(command.lotId().value())
                .orElseThrow(() -> new RuntimeException("Lot not found"));
        
        entity.setLotName(command.lotName());
        entity.setCoffeeType(command.coffeeType());
        entity.setProcessingMethod(command.processingMethod());
        entity.setAltitude(command.altitude());
        entity.setWeight(command.weight());
        entity.setCertifications(String.join(",", command.certifications()));
        entity.setOrigin(command.origin());
        
        LotEntity saved = lotRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public boolean deleteLot(DeleteLotCommand command) {
        if (lotRepository.existsById(command.lotId().value())) {
            lotRepository.deleteById(command.lotId().value());
            return true;
        }
        return false;
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
                new Origin(entity.getOrigin())
        );
    }
} 