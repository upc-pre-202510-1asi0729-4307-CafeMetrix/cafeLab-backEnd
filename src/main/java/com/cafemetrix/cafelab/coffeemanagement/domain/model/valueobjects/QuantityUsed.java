package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class QuantityUsed {
    private final Double value;

    public QuantityUsed(Double value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
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
        QuantityUsed that = (QuantityUsed) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 