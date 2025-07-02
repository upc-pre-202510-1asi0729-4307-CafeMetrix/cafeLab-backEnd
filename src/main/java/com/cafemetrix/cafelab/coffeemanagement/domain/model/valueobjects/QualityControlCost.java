package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record QualityControlCost(Double value) {
    public QualityControlCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Quality control cost must be non-negative");
        }
    }
} 