package com.cafemetrix.cafelab.coffeemanagement.domain.model.commands;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;

public record UpdateInventoryEntryCommand(
    InventoryEntryId id,
    QuantityUsed quantityUsed,
    DateUsed dateUsed,
    FinalProduct finalProduct
) {} 