package com.cafemetrix.cafelab.coffeemanagement.application.internal.commandservices;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.InventoryEntry;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.InventoryEntryCommandService;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities.InventoryEntryEntity;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.repositories.InventoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryEntryCommandServiceImpl implements InventoryEntryCommandService {
    
    @Autowired
    private InventoryEntryRepository inventoryEntryRepository;

    @Override
    public InventoryEntry createInventoryEntry(CreateInventoryEntryCommand command) {
        InventoryEntryEntity entity = new InventoryEntryEntity();
        entity.setCoffeeLotId(command.coffeeLotId().value());
        entity.setUserId(command.userId().value());
        entity.setQuantityUsed(command.quantityUsed().value());
        entity.setDateUsed(command.dateUsed().value());
        entity.setFinalProduct(command.finalProduct().value());
        
        InventoryEntryEntity saved = inventoryEntryRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public InventoryEntry updateInventoryEntry(UpdateInventoryEntryCommand command) {
        InventoryEntryEntity entity = inventoryEntryRepository.findById(command.id().value())
                .orElseThrow(() -> new RuntimeException("Inventory entry not found"));
        
        entity.setQuantityUsed(command.quantityUsed().value());
        entity.setDateUsed(command.dateUsed().value());
        entity.setFinalProduct(command.finalProduct().value());
        
        InventoryEntryEntity saved = inventoryEntryRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public boolean deleteInventoryEntry(DeleteInventoryEntryCommand command) {
        if (inventoryEntryRepository.existsById(command.id().value())) {
            inventoryEntryRepository.deleteById(command.id().value());
            return true;
        }
        return false;
    }

    private InventoryEntry toDomain(InventoryEntryEntity entity) {
        return new InventoryEntry(
                new InventoryEntryId(entity.getId()),
                new LotId(entity.getCoffeeLotId()),
                new UserId(entity.getUserId()),
                new QuantityUsed(entity.getQuantityUsed()),
                new DateUsed(entity.getDateUsed()),
                new FinalProduct(entity.getFinalProduct())
        );
    }
} 