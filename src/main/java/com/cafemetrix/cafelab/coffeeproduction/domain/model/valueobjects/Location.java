package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record Location(String value) {
    public Location {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        if (value.trim().length() < 3) {
            throw new IllegalArgumentException("Location must be at least 3 characters long");
        }
        if (value.trim().length() > 500) {
            throw new IllegalArgumentException("Location cannot exceed 500 characters");
        }
    }
} 