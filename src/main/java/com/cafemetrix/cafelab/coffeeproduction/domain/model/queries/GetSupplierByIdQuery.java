package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.SupplierId;

public record GetSupplierByIdQuery(SupplierId supplierId) {
    public GetSupplierByIdQuery {
        if (supplierId == null) {
            throw new IllegalArgumentException("SupplierId cannot be null");
        }
    }
} 