package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record SuppliesCost(Double value) {
    public SuppliesCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Supplies cost must be non-negative");
        }
    }
} 