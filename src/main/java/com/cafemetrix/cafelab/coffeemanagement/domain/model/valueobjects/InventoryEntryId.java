package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class InventoryEntryId {
    private final Long value;

    public InventoryEntryId(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InventoryEntryId that = (InventoryEntryId) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 