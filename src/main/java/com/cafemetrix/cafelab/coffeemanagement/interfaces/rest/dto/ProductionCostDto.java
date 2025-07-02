package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

import java.time.LocalDateTime;

public record ProductionCostDto(
    Long id,
    Long coffeeLotId,
    Long userId,
    DirectCostsDto directCosts,
    IndirectCostsDto indirectCosts,
    CostSummaryDto costSummary,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {} 