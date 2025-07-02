package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record TotalCost(Double value) {
    public TotalCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Total cost must be non-negative");
        }
    }
} 