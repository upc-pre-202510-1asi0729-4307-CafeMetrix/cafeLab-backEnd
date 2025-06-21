package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record RoastType(String value) {
    public RoastType {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Roast type cannot be null or empty");
        }
        if (value.trim().length() > 100) {
            throw new IllegalArgumentException("Roast type cannot exceed 100 characters");
        }
    }
} 