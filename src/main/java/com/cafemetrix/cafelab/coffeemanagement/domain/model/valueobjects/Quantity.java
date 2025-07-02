package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class Quantity {
    private final Double value;

    public Quantity(Double value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        this.value = value;
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity that = (Quantity) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 