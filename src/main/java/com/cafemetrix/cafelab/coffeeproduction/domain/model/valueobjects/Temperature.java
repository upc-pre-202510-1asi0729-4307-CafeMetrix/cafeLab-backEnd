package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record Temperature(double value) {
    public Temperature {
        if (value < -50) {
            throw new IllegalArgumentException("Temperature cannot be less than -50°C");
        }
        if (value > 300) {
            throw new IllegalArgumentException("Temperature cannot exceed 300°C");
        }
    }
} 