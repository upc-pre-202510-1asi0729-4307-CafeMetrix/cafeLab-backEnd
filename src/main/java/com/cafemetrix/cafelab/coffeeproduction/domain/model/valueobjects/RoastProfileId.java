package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record RoastProfileId(Long value) {
    public RoastProfileId {
        if (value == null) {
            throw new IllegalArgumentException("RoastProfileId cannot be null");
        }
    }
} 