package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class CostPerHour {
    private final Double value;

    public CostPerHour(Double value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Cost per hour must be non-negative");
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
        CostPerHour that = (CostPerHour) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 