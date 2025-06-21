package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

public record SupplierId(Long value) {
    public SupplierId {
        if (value == null) {
            throw new IllegalArgumentException("SupplierId cannot be null");
        }
    }
} 