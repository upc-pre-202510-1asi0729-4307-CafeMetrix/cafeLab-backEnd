package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class LotId {
    private final Long value;

    public LotId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LotId that = (LotId) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 