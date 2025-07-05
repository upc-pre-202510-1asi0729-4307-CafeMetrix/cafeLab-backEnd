package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record ProfileName(String value) {
    public ProfileName {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Profile name cannot be null or empty");
        }
        if (value.trim().length() < 3) {
            throw new IllegalArgumentException("Profile name must be at least 3 characters long");
        }
        if (value.trim().length() > 255) {
            throw new IllegalArgumentException("Profile name cannot exceed 255 characters");
        }
    }
} 