package com.cafemetrix.cafelab.coffeemanagement.domain.services;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.InventoryEntry;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.*;

public interface InventoryEntryCommandService {
    InventoryEntry createInventoryEntry(CreateInventoryEntryCommand command);
    InventoryEntry updateInventoryEntry(UpdateInventoryEntryCommand command);
    boolean deleteInventoryEntry(DeleteInventoryEntryCommand command);
} 