package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class CostSummary {
    private final TotalCost totalCost;
    private final CostPerKg costPerKg;
    private final SuggestedPrice suggestedPrice;
    private final PotentialMargin potentialMargin;
    private final TotalDirectCost totalDirectCost;
    private final TotalIndirectCost totalIndirectCost;

    public CostSummary(TotalCost totalCost, CostPerKg costPerKg, SuggestedPrice suggestedPrice,
                      PotentialMargin potentialMargin, TotalDirectCost totalDirectCost, 
                      TotalIndirectCost totalIndirectCost) {
        this.totalCost = totalCost;
        this.costPerKg = costPerKg;
        this.suggestedPrice = suggestedPrice;
        this.potentialMargin = potentialMargin;
        this.totalDirectCost = totalDirectCost;
        this.totalIndirectCost = totalIndirectCost;
    }

    public TotalCost getTotalCost() { return totalCost; }
    public CostPerKg getCostPerKg() { return costPerKg; }
    public SuggestedPrice getSuggestedPrice() { return suggestedPrice; }
    public PotentialMargin getPotentialMargin() { return potentialMargin; }
    public TotalDirectCost getTotalDirectCost() { return totalDirectCost; }
    public TotalIndirectCost getTotalIndirectCost() { return totalIndirectCost; }
} 