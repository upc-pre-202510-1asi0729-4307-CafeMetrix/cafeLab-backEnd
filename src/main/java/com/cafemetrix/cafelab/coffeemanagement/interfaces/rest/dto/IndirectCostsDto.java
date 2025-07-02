package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record IndirectCostsDto(
    TransportCostDto transportCost,
    StorageCostDto storageCost,
    ProcessingCostDto processingCost,
    OtherCostsDto otherCosts,
    Double totalCost
) {} 