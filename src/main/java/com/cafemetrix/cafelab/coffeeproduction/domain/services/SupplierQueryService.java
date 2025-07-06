package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllSuppliersQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSuppliersByUserIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Supplier Query Service Interface
 */
public interface SupplierQueryService {
    List<Supplier> handle(GetAllSuppliersQuery query);
    Optional<Supplier> handle(GetSupplierByIdQuery query);
    List<Supplier> handle(GetSuppliersByUserIdQuery query);
} 