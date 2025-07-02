package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record MaintenanceCost(Double value) {
    public MaintenanceCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Maintenance cost must be non-negative");
        }
    }
} 