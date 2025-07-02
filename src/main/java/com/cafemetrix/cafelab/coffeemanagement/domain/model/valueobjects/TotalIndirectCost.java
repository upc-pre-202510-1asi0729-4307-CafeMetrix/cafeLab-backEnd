package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record TotalIndirectCost(Double value) {
    public TotalIndirectCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Total indirect cost must be non-negative");
        }
    }
} 