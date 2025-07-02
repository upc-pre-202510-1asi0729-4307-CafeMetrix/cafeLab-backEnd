package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class FinalProduct {
    private final String value;

    public FinalProduct(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Final product cannot be empty");
        }
        this.value = value.trim();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FinalProduct that = (FinalProduct) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 