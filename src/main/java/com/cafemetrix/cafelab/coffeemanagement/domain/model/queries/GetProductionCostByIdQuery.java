package com.cafemetrix.cafelab.coffeemanagement.domain.model.queries;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.ProductionCostId;

public record GetProductionCostByIdQuery(
    ProductionCostId id
) {} 