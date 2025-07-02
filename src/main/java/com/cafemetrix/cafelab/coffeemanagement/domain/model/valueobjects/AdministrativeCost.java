package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record AdministrativeCost(Double value) {
    public AdministrativeCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Administrative cost must be non-negative");
        }
    }
} 