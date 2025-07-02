package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class HoursWorked {
    private final Double value;

    public HoursWorked(Double value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Hours worked must be non-negative");
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
        HoursWorked that = (HoursWorked) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 