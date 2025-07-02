package com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_entries")
public class InventoryEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coffee_lot_id", nullable = false)
    private Long coffeeLotId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "quantity_used", nullable = false)
    private Double quantityUsed;

    @Column(name = "date_used", nullable = false)
    private LocalDateTime dateUsed;

    @Column(name = "final_product", nullable = false)
    private String finalProduct;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getCoffeeLotId() { return coffeeLotId; }
    public void setCoffeeLotId(Long coffeeLotId) { this.coffeeLotId = coffeeLotId; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Double getQuantityUsed() { return quantityUsed; }
    public void setQuantityUsed(Double quantityUsed) { this.quantityUsed = quantityUsed; }
    
    public LocalDateTime getDateUsed() { return dateUsed; }
    public void setDateUsed(LocalDateTime dateUsed) { this.dateUsed = dateUsed; }
    
    public String getFinalProduct() { return finalProduct; }
    public void setFinalProduct(String finalProduct) { this.finalProduct = finalProduct; }
} 