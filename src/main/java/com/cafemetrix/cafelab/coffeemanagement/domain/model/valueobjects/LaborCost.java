package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class LaborCost {
    private final HoursWorked hoursWorked;
    private final CostPerHour costPerHour;
    private final NumberOfWorkers numberOfWorkers;

    public LaborCost(HoursWorked hoursWorked, CostPerHour costPerHour, NumberOfWorkers numberOfWorkers) {
        this.hoursWorked = hoursWorked;
        this.costPerHour = costPerHour;
        this.numberOfWorkers = numberOfWorkers;
    }

    public HoursWorked getHoursWorked() { return hoursWorked; }
    public CostPerHour getCostPerHour() { return costPerHour; }
    public NumberOfWorkers getNumberOfWorkers() { return numberOfWorkers; }

    public double getTotalCost() {
        return hoursWorked.value() * costPerHour.value() * numberOfWorkers.value();
    }
} 