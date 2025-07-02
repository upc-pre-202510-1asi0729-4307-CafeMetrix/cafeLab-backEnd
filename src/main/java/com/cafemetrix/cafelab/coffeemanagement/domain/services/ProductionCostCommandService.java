package com.cafemetrix.cafelab.coffeemanagement.domain.services;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.ProductionCost;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.*;

public interface ProductionCostCommandService {
    ProductionCost createProductionCost(CreateProductionCostCommand command);
    ProductionCost updateProductionCost(UpdateProductionCostCommand command);
    boolean deleteProductionCost(DeleteProductionCostCommand command);
} 