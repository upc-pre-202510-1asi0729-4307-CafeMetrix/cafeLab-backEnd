package com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lots")
public class LotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "lot_name", nullable = false)
    private String lotName;

    @Column(name = "coffee_type", nullable = false)
    private String coffeeType;

    @Column(name = "processing_method", nullable = false)
    private String processingMethod;

    @Column(nullable = false)
    private String altitude;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    private String certifications;

    @Column(nullable = false)
    private String origin;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getLotName() { return lotName; }
    public void setLotName(String lotName) { this.lotName = lotName; }
    public String getCoffeeType() { return coffeeType; }
    public void setCoffeeType(String coffeeType) { this.coffeeType = coffeeType; }
    public String getProcessingMethod() { return processingMethod; }
    public void setProcessingMethod(String processingMethod) { this.processingMethod = processingMethod; }
    public String getAltitude() { return altitude; }
    public void setAltitude(String altitude) { this.altitude = altitude; }
    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }
    public String getCertifications() { return certifications; }
    public void setCertifications(String certifications) { this.certifications = certifications; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
} 