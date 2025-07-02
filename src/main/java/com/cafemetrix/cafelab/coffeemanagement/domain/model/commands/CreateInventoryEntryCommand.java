package com.cafemetrix.cafelab.coffeemanagement.domain.model.commands;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;

public record CreateInventoryEntryCommand(
    LotId coffeeLotId,
    UserId userId,
    QuantityUsed quantityUsed,
    DateUsed dateUsed,
    FinalProduct finalProduct
) {} 