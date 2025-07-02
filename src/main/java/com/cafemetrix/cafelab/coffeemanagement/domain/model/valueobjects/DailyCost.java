package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class DailyCost {
    private final Double value;

    public DailyCost(Double value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Daily cost must be non-negative");
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
        DailyCost that = (DailyCost) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 