package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record DepreciationCost(Double value) {
    public DepreciationCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Depreciation cost must be non-negative");
        }
    }
} 