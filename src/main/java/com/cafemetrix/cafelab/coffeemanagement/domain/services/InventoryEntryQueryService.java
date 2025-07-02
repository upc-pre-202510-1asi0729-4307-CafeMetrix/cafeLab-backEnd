package com.cafemetrix.cafelab.coffeemanagement.domain.services;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.InventoryEntry;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface InventoryEntryQueryService {
    List<InventoryEntry> getAllInventoryEntries(GetAllInventoryEntriesQuery query);
    Optional<InventoryEntry> getInventoryEntryById(GetInventoryEntryByIdQuery query);
    List<InventoryEntry> getInventoryEntriesByLot(GetInventoryEntriesByLotQuery query);
} 