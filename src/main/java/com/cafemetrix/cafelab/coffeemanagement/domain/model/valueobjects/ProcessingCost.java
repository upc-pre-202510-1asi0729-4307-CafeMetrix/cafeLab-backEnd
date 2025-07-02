package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class ProcessingCost {
    private final ElectricityCost electricityCost;
    private final MaintenanceCost maintenanceCost;
    private final SuppliesCost suppliesCost;
    private final WaterCost waterCost;
    private final DepreciationCost depreciationCost;

    public ProcessingCost(ElectricityCost electricityCost, MaintenanceCost maintenanceCost,
                         SuppliesCost suppliesCost, WaterCost waterCost, DepreciationCost depreciationCost) {
        this.electricityCost = electricityCost;
        this.maintenanceCost = maintenanceCost;
        this.suppliesCost = suppliesCost;
        this.waterCost = waterCost;
        this.depreciationCost = depreciationCost;
    }

    public ElectricityCost getElectricityCost() { return electricityCost; }
    public MaintenanceCost getMaintenanceCost() { return maintenanceCost; }
    public SuppliesCost getSuppliesCost() { return suppliesCost; }
    public WaterCost getWaterCost() { return waterCost; }
    public DepreciationCost getDepreciationCost() { return depreciationCost; }

    public double getTotalCost() {
        return electricityCost.value() + maintenanceCost.value() + suppliesCost.value() + 
               waterCost.value() + depreciationCost.value();
    }
} 