package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class ProductionCostId {
    private final Long value;

    public ProductionCostId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductionCostId that = (ProductionCostId) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 