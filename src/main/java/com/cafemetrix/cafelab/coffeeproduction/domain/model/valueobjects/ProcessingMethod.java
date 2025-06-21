package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record ProcessingMethod(String value) {
    public ProcessingMethod {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Processing method cannot be null or empty");
        }
        if (value.trim().length() > 100) {
            throw new IllegalArgumentException("Processing method cannot exceed 100 characters");
        }
    }
} 