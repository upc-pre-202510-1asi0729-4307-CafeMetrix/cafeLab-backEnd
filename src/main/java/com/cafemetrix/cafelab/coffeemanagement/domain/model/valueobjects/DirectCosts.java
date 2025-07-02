package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class DirectCosts {
    private final RawMaterialsCost rawMaterialsCost;
    private final LaborCost laborCost;

    public DirectCosts(RawMaterialsCost rawMaterialsCost, LaborCost laborCost) {
        this.rawMaterialsCost = rawMaterialsCost;
        this.laborCost = laborCost;
    }

    public RawMaterialsCost getRawMaterialsCost() { return rawMaterialsCost; }
    public LaborCost getLaborCost() { return laborCost; }

    public double getTotalCost() {
        return rawMaterialsCost.getTotalCost() + laborCost.getTotalCost();
    }
} 