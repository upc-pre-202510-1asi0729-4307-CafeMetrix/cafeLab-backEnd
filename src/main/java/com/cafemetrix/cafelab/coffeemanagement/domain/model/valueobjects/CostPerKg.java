package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record CostPerKg(Double value) {
    public CostPerKg {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Cost per kg must be non-negative");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CostPerKg that = (CostPerKg) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 