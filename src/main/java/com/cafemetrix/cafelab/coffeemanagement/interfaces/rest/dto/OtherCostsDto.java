package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record OtherCostsDto(
    Double qualityControl,
    Double certifications,
    Double insurance,
    Double administrative,
    Double totalCost
) {} 