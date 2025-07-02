package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class StorageCost {
    private final DaysInStorage daysInStorage;
    private final DailyCost dailyCost;

    public StorageCost(DaysInStorage daysInStorage, DailyCost dailyCost) {
        this.daysInStorage = daysInStorage;
        this.dailyCost = dailyCost;
    }

    public DaysInStorage getDaysInStorage() { return daysInStorage; }
    public DailyCost getDailyCost() { return dailyCost; }

    public double getTotalCost() {
        return daysInStorage.value() * dailyCost.value();
    }
} 