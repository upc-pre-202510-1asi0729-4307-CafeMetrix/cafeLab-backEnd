package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class UserId {
    private final Long value;

    public UserId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserId that = (UserId) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 