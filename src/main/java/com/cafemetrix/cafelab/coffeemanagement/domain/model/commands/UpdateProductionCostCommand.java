package com.cafemetrix.cafelab.coffeemanagement.domain.model.commands;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;

public record UpdateProductionCostCommand(
    ProductionCostId id,
    DirectCosts directCosts,
    IndirectCosts indirectCosts
) {} 