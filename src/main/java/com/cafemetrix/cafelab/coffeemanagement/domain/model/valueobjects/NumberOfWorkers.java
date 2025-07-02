package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class NumberOfWorkers {
    private final Integer value;

    public NumberOfWorkers(Integer value) {
        if (value == null || value < 1) {
            throw new IllegalArgumentException("Number of workers must be at least 1");
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
        NumberOfWorkers that = (NumberOfWorkers) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 