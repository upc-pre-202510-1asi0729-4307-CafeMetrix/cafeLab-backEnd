package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class RawMaterialsCost {
    private final CostPerKg costPerKg;
    private final Quantity quantity;

    public RawMaterialsCost(CostPerKg costPerKg, Quantity quantity) {
        this.costPerKg = costPerKg;
        this.quantity = quantity;
    }

    public CostPerKg getCostPerKg() { return costPerKg; }
    public Quantity getQuantity() { return quantity; }

    public double getTotalCost() {
        return costPerKg.value() * quantity.value();
    }
} 