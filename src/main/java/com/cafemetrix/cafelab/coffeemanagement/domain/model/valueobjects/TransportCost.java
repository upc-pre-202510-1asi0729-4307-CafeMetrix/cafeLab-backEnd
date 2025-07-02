package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class TransportCost {
    private final CostPerKg costPerKg;
    private final Quantity quantity;

    public TransportCost(CostPerKg costPerKg, Quantity quantity) {
        this.costPerKg = costPerKg;
        this.quantity = quantity;
    }

    public CostPerKg getCostPerKg() { return costPerKg; }
    public Quantity getQuantity() { return quantity; }

    public double getTotalCost() {
        return costPerKg.value() * quantity.value();
    }
} 