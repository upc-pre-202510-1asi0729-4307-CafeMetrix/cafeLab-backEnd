package com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;

import java.time.LocalDateTime;

public class InventoryEntry {
    private final InventoryEntryId id;
    private final LotId coffeeLotId;
    private final UserId userId;
    private QuantityUsed quantityUsed;
    private DateUsed dateUsed;
    private FinalProduct finalProduct;

    public InventoryEntry(InventoryEntryId id, LotId coffeeLotId, UserId userId, 
                         QuantityUsed quantityUsed, DateUsed dateUsed, FinalProduct finalProduct) {
        this.id = id;
        this.coffeeLotId = coffeeLotId;
        this.userId = userId;
        this.quantityUsed = quantityUsed;
        this.dateUsed = dateUsed;
        this.finalProduct = finalProduct;
    }

    // Getters
    public InventoryEntryId getId() { return id; }
    public LotId getCoffeeLotId() { return coffeeLotId; }
    public UserId getUserId() { return userId; }
    public QuantityUsed getQuantityUsed() { return quantityUsed; }
    public DateUsed getDateUsed() { return dateUsed; }
    public FinalProduct getFinalProduct() { return finalProduct; }

    // Setters
    public void setQuantityUsed(QuantityUsed quantityUsed) { this.quantityUsed = quantityUsed; }
    public void setDateUsed(DateUsed dateUsed) { this.dateUsed = dateUsed; }
    public void setFinalProduct(FinalProduct finalProduct) { this.finalProduct = finalProduct; }
} 