package com.cafemetrix.cafelab.coffeemanagement.domain.services;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.ProductionCost;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface ProductionCostQueryService {
    List<ProductionCost> getAllProductionCosts(GetAllProductionCostsQuery query);
    Optional<ProductionCost> getProductionCostById(GetProductionCostByIdQuery query);
    List<ProductionCost> getProductionCostsByLot(GetProductionCostsByLotQuery query);
} 