package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record Origin(String value) {
    public Origin {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin cannot be null or empty");
        }
        if (value.trim().length() < 3) {
            throw new IllegalArgumentException("Origin must be at least 3 characters long");
        }
        if (value.trim().length() > 255) {
            throw new IllegalArgumentException("Origin cannot exceed 255 characters");
        }
    }
} 