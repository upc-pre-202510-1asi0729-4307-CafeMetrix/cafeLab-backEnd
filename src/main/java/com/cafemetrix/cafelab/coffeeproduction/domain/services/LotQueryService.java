package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllLotsQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetLotByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetLotByNameQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetLotsBySupplierQuery;

import java.util.List;
import java.util.Optional;

public interface LotQueryService {
    List<Lot> getAllLots(GetAllLotsQuery query);
    Optional<Lot> getLotByName(GetLotByNameQuery query);
    Optional<Lot> getLotById(GetLotByIdQuery query);
    List<Lot> getLotsBySupplier(GetLotsBySupplierQuery query);
} 