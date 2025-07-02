package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record UpdateProductionCostRequest(
    DirectCostsDto directCosts,
    IndirectCostsDto indirectCosts
) {} 