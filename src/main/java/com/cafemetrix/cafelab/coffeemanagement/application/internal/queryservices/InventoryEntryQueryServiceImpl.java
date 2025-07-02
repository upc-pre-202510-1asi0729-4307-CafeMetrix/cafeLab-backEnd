package com.cafemetrix.cafelab.coffeemanagement.application.internal.queryservices;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.InventoryEntry;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.InventoryEntryQueryService;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities.InventoryEntryEntity;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.repositories.InventoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryEntryQueryServiceImpl implements InventoryEntryQueryService {
    
    @Autowired
    private InventoryEntryRepository inventoryEntryRepository;

    @Override
    public List<InventoryEntry> getAllInventoryEntries(GetAllInventoryEntriesQuery query) {
        return inventoryEntryRepository.findAllByUserId(query.userId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InventoryEntry> getInventoryEntryById(GetInventoryEntryByIdQuery query) {
        return inventoryEntryRepository.findById(query.id().value())
                .map(this::toDomain);
    }

    @Override
    public List<InventoryEntry> getInventoryEntriesByLot(GetInventoryEntriesByLotQuery query) {
        return inventoryEntryRepository.findAllByCoffeeLotId(query.lotId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
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