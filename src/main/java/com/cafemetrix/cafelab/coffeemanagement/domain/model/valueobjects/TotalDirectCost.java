package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record TotalDirectCost(Double value) {
    public TotalDirectCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Total direct cost must be non-negative");
        }
    }
} 