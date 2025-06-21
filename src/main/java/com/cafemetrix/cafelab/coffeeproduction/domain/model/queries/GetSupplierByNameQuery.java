package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

public record GetSupplierByNameQuery(String name) {
    public GetSupplierByNameQuery {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
} 