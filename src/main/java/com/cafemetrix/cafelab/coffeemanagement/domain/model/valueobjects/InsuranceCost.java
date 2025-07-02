package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record InsuranceCost(Double value) {
    public InsuranceCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Insurance cost must be non-negative");
        }
    }
} 