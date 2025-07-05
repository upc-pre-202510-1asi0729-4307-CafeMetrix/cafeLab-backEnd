package com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;

public class Lot {
    private final LotId id;
    private final SupplierId supplierId;
    private final UserId userId;
    private LotName lotName;
    private CoffeeType coffeeType;
    private ProcessingMethod processingMethod;
    private Altitude altitude;
    private Weight weight;
    private Certifications certifications;
    private Origin origin;

    public Lot(LotId id, SupplierId supplierId, UserId userId, LotName lotName, CoffeeType coffeeType, 
               ProcessingMethod processingMethod, Altitude altitude, Weight weight, Certifications certifications, Origin origin) {
        this.id = id;
        this.supplierId = supplierId;
        this.userId = userId;
        this.lotName = lotName;
        this.coffeeType = coffeeType;
        this.processingMethod = processingMethod;
        this.altitude = altitude;
        this.weight = weight;
        this.certifications = certifications;
        this.origin = origin;
    }

    // Getters
    public LotId getId() { return id; }
    public SupplierId getSupplierId() { return supplierId; }
    public UserId getUserId() { return userId; }
    public LotName getLotName() { return lotName; }
    public CoffeeType getCoffeeType() { return coffeeType; }
    public ProcessingMethod getProcessingMethod() { return processingMethod; }
    public Altitude getAltitude() { return altitude; }
    public Weight getWeight() { return weight; }
    public Certifications getCertifications() { return certifications; }
    public Origin getOrigin() { return origin; }

    // Setters
    public void setLotName(LotName lotName) { this.lotName = lotName; }
    public void setCoffeeType(CoffeeType coffeeType) { this.coffeeType = coffeeType; }
    public void setProcessingMethod(ProcessingMethod processingMethod) { this.processingMethod = processingMethod; }
    public void setAltitude(Altitude altitude) { this.altitude = altitude; }
    public void setWeight(Weight weight) { this.weight = weight; }
    public void setCertifications(Certifications certifications) { this.certifications = certifications; }
    public void setOrigin(Origin origin) { this.origin = origin; }
} 