package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record CoffeeType(String value) {
    public CoffeeType {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Coffee type cannot be null or empty");
        }
        if (value.trim().length() > 100) {
            throw new IllegalArgumentException("Coffee type cannot exceed 100 characters");
        }
    }
} 