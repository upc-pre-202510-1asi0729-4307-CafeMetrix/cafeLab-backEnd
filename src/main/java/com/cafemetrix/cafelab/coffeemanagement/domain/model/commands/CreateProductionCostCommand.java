package com.cafemetrix.cafelab.coffeemanagement.domain.model.commands;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;

public record CreateProductionCostCommand(
    LotId coffeeLotId,
    UserId userId,
    DirectCosts directCosts,
    IndirectCosts indirectCosts
) {} 