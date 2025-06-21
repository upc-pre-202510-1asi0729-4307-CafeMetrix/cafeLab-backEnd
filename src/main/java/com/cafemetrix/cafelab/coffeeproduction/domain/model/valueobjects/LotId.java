package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record LotId(Long value) {
    public LotId {
        if (value == null) {
            throw new IllegalArgumentException("LotId cannot be null");
        }
    }
} 