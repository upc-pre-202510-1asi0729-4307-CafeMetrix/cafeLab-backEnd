package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.CoffeeLot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllCoffeeLotsQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetCoffeeLotByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetCoffeeLotsBySupplierIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetCoffeeLotsByUserIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * CoffeeLot Query Service Interface
 */
public interface CoffeeLotQueryService {
    List<CoffeeLot> handle(GetAllCoffeeLotsQuery query);
    Optional<CoffeeLot> handle(GetCoffeeLotByIdQuery query);
    List<CoffeeLot> handle(GetCoffeeLotsByUserIdQuery query);
    List<CoffeeLot> handle(GetCoffeeLotsBySupplierIdQuery query);
} 