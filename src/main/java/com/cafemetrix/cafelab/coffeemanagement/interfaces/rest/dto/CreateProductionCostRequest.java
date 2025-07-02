package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record CreateProductionCostRequest(
    Long coffeeLotId,
    DirectCostsDto directCosts,
    IndirectCostsDto indirectCosts
) {} 