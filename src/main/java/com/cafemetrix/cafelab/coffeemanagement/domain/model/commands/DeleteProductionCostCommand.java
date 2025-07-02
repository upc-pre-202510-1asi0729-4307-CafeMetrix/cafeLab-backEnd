package com.cafemetrix.cafelab.coffeemanagement.domain.model.commands;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.ProductionCostId;

public record DeleteProductionCostCommand(
    ProductionCostId id
) {} 