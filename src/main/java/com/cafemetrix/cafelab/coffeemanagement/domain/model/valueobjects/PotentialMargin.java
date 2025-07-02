package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record PotentialMargin(Double value) {
    public PotentialMargin {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Potential margin must be non-negative");
        }
    }
} 