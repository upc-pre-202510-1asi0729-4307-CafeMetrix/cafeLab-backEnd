package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record UserId(Long value) {
    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
    }
} 