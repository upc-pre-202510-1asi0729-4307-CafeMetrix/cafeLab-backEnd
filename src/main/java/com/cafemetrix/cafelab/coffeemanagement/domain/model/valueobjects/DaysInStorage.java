package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class DaysInStorage {
    private final Integer value;

    public DaysInStorage(Integer value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Days in storage must be non-negative");
        }
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DaysInStorage that = (DaysInStorage) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 