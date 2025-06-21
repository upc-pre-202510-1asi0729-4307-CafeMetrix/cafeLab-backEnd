package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record Duration(int value) {
    public Duration {
        if (value <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        if (value > 1000) {
            throw new IllegalArgumentException("Duration cannot exceed 1000 minutes");
        }
    }
} 