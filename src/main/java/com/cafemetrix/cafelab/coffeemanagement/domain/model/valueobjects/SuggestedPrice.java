package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record SuggestedPrice(Double value) {
    public SuggestedPrice {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Suggested price must be non-negative");
        }
    }
} 