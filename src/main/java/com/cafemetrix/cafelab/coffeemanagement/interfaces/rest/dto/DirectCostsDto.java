package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record DirectCostsDto(
    RawMaterialsCostDto rawMaterialsCost,
    LaborCostDto laborCost,
    Double totalCost
) {} 