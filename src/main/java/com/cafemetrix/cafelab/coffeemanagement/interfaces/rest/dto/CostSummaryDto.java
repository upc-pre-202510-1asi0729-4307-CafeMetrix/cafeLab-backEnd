package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record CostSummaryDto(
    Double totalCost,
    Double costPerKg,
    Double suggestedPrice,
    Double potentialMargin,
    Double totalDirectCost,
    Double totalIndirectCost
) {} 