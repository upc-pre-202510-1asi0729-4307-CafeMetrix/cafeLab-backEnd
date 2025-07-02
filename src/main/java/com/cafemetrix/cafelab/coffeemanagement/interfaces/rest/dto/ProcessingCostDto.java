package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record ProcessingCostDto(
    Double electricity,
    Double maintenance,
    Double supplies,
    Double water,
    Double depreciation,
    Double totalCost
) {} 