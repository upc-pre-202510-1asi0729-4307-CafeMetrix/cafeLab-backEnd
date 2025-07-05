package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllSuppliersQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByNameQuery;

import java.util.List;
import java.util.Optional;

public interface SupplierQueryService {
    List<Supplier> getAllSuppliers(GetAllSuppliersQuery query);
    Optional<Supplier> getSupplierByName(GetSupplierByNameQuery query);
    Optional<Supplier> getSupplierById(GetSupplierByIdQuery query);
} 