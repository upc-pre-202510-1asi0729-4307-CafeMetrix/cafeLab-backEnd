package com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "production_costs")
public class ProductionCostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coffee_lot_id", nullable = false)
    private Long coffeeLotId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    // Costos directos
    @Column(name = "raw_materials_cost", nullable = false)
    private Double rawMaterialsCost;
    @Column(name = "raw_materials_quantity", nullable = false)
    private Double rawMaterialsQuantity;
    @Column(name = "labor_hours", nullable = false)
    private Double laborHours;
    @Column(name = "labor_cost_per_hour", nullable = false)
    private Double laborCostPerHour;
    @Column(name = "labor_workers", nullable = false)
    private Integer laborWorkers;

    // Costos indirectos
    @Column(name = "transport_cost", nullable = false)
    private Double transportCost;
    @Column(name = "transport_quantity", nullable = false)
    private Double transportQuantity;
    @Column(name = "storage_days", nullable = false)
    private Integer storageDays;
    @Column(name = "storage_daily_cost", nullable = false)
    private Double storageDailyCost;
    @Column(name = "processing_electricity", nullable = false)
    private Double processingElectricity;
    @Column(name = "processing_maintenance", nullable = false)
    private Double processingMaintenance;
    @Column(name = "processing_supplies", nullable = false)
    private Double processingSupplies;
    @Column(name = "processing_water", nullable = false)
    private Double processingWater;
    @Column(name = "processing_depreciation", nullable = false)
    private Double processingDepreciation;
    @Column(name = "other_quality_control", nullable = false)
    private Double otherQualityControl;
    @Column(name = "other_certifications", nullable = false)
    private Double otherCertifications;
    @Column(name = "other_insurance", nullable = false)
    private Double otherInsurance;
    @Column(name = "other_administrative", nullable = false)
    private Double otherAdministrative;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getCoffeeLotId() { return coffeeLotId; }
    public void setCoffeeLotId(Long coffeeLotId) { this.coffeeLotId = coffeeLotId; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Double getRawMaterialsCost() { return rawMaterialsCost; }
    public void setRawMaterialsCost(Double rawMaterialsCost) { this.rawMaterialsCost = rawMaterialsCost; }
    
    public Double getRawMaterialsQuantity() { return rawMaterialsQuantity; }
    public void setRawMaterialsQuantity(Double rawMaterialsQuantity) { this.rawMaterialsQuantity = rawMaterialsQuantity; }
    
    public Double getLaborHours() { return laborHours; }
    public void setLaborHours(Double laborHours) { this.laborHours = laborHours; }
    
    public Double getLaborCostPerHour() { return laborCostPerHour; }
    public void setLaborCostPerHour(Double laborCostPerHour) { this.laborCostPerHour = laborCostPerHour; }
    
    public Integer getLaborWorkers() { return laborWorkers; }
    public void setLaborWorkers(Integer laborWorkers) { this.laborWorkers = laborWorkers; }
    
    public Double getTransportCost() { return transportCost; }
    public void setTransportCost(Double transportCost) { this.transportCost = transportCost; }
    
    public Double getTransportQuantity() { return transportQuantity; }
    public void setTransportQuantity(Double transportQuantity) { this.transportQuantity = transportQuantity; }
    
    public Integer getStorageDays() { return storageDays; }
    public void setStorageDays(Integer storageDays) { this.storageDays = storageDays; }
    
    public Double getStorageDailyCost() { return storageDailyCost; }
    public void setStorageDailyCost(Double storageDailyCost) { this.storageDailyCost = storageDailyCost; }
    
    public Double getProcessingElectricity() { return processingElectricity; }
    public void setProcessingElectricity(Double processingElectricity) { this.processingElectricity = processingElectricity; }
    
    public Double getProcessingMaintenance() { return processingMaintenance; }
    public void setProcessingMaintenance(Double processingMaintenance) { this.processingMaintenance = processingMaintenance; }
    
    public Double getProcessingSupplies() { return processingSupplies; }
    public void setProcessingSupplies(Double processingSupplies) { this.processingSupplies = processingSupplies; }
    
    public Double getProcessingWater() { return processingWater; }
    public void setProcessingWater(Double processingWater) { this.processingWater = processingWater; }
    
    public Double getProcessingDepreciation() { return processingDepreciation; }
    public void setProcessingDepreciation(Double processingDepreciation) { this.processingDepreciation = processingDepreciation; }
    
    public Double getOtherQualityControl() { return otherQualityControl; }
    public void setOtherQualityControl(Double otherQualityControl) { this.otherQualityControl = otherQualityControl; }
    
    public Double getOtherCertifications() { return otherCertifications; }
    public void setOtherCertifications(Double otherCertifications) { this.otherCertifications = otherCertifications; }
    
    public Double getOtherInsurance() { return otherInsurance; }
    public void setOtherInsurance(Double otherInsurance) { this.otherInsurance = otherInsurance; }
    
    public Double getOtherAdministrative() { return otherAdministrative; }
    public void setOtherAdministrative(Double otherAdministrative) { this.otherAdministrative = otherAdministrative; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
} 