package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record WaterCost(Double value) {
    public WaterCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Water cost must be non-negative");
        }
    }
} 