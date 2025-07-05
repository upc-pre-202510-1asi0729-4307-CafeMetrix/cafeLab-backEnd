package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record Weight(String value) {
    public Weight {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Weight cannot be null or empty");
        }
        if (value.trim().length() > 50) {
            throw new IllegalArgumentException("Weight cannot exceed 50 characters");
        }
    }
} 