package com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;

import java.time.LocalDateTime;

public class ProductionCost {
    private final ProductionCostId id;
    private final LotId coffeeLotId;
    private final UserId userId;
    private DirectCosts directCosts;
    private IndirectCosts indirectCosts;
    private CostSummary costSummary;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductionCost(ProductionCostId id, LotId coffeeLotId, UserId userId, 
                         DirectCosts directCosts, IndirectCosts indirectCosts) {
        this.id = id;
        this.coffeeLotId = coffeeLotId;
        this.userId = userId;
        this.directCosts = directCosts;
        this.indirectCosts = indirectCosts;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.calculateCostSummary();
    }

    // Getters
    public ProductionCostId getId() { return id; }
    public LotId getCoffeeLotId() { return coffeeLotId; }
    public UserId getUserId() { return userId; }
    public DirectCosts getDirectCosts() { return directCosts; }
    public IndirectCosts getIndirectCosts() { return indirectCosts; }
    public CostSummary getCostSummary() { return costSummary; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // Setters
    public void setDirectCosts(DirectCosts directCosts) { 
        this.directCosts = directCosts; 
        this.updatedAt = LocalDateTime.now();
        this.calculateCostSummary();
    }
    
    public void setIndirectCosts(IndirectCosts indirectCosts) { 
        this.indirectCosts = indirectCosts; 
        this.updatedAt = LocalDateTime.now();
        this.calculateCostSummary();
    }

    private void calculateCostSummary() {
        double totalDirectCost = directCosts.getTotalCost();
        double totalIndirectCost = indirectCosts.getTotalCost();
        double totalCost = totalDirectCost + totalIndirectCost;
        double quantity = directCosts.getRawMaterialsCost().getQuantity().value();
        double costPerKg = quantity > 0 ? totalCost / quantity : 0;
        double suggestedPrice = costPerKg * 1.45; // 45% margin
        double potentialMargin = suggestedPrice - costPerKg;

        this.costSummary = new CostSummary(
            new TotalCost(totalCost),
            new CostPerKg(costPerKg),
            new SuggestedPrice(suggestedPrice),
            new PotentialMargin(potentialMargin),
            new TotalDirectCost(totalDirectCost),
            new TotalIndirectCost(totalIndirectCost)
        );
    }
} 