package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.transformers;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.InventoryEntry;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.CreateInventoryEntryCommand;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.UpdateInventoryEntryCommand;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto.*;

public class InventoryEntryTransformer {
    
    public static InventoryEntryDto toDto(InventoryEntry inventoryEntry) {
        return new InventoryEntryDto(
                inventoryEntry.getId().value(),
                inventoryEntry.getCoffeeLotId().value(),
                inventoryEntry.getUserId().value(),
                inventoryEntry.getQuantityUsed().value(),
                inventoryEntry.getDateUsed().value(),
                inventoryEntry.getFinalProduct().value()
        );
    }
    
    public static CreateInventoryEntryCommand toCreateCommand(CreateInventoryEntryRequest request, Long userId) {
        return new CreateInventoryEntryCommand(
                new LotId(request.coffeeLotId()),
                new UserId(userId),
                new QuantityUsed(request.quantityUsed()),
                new DateUsed(request.dateUsed()),
                new FinalProduct(request.finalProduct())
        );
    }
    
    public static UpdateInventoryEntryCommand toUpdateCommand(UpdateInventoryEntryRequest request, Long id) {
        return new UpdateInventoryEntryCommand(
                new InventoryEntryId(id),
                new QuantityUsed(request.quantityUsed()),
                new DateUsed(request.dateUsed()),
                new FinalProduct(request.finalProduct())
        );
    }
} 