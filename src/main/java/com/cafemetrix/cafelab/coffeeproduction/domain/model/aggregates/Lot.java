package com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateLotCommand;

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
    private String status; // 'green' or 'roasted'

    public Lot(LotId id, SupplierId supplierId, UserId userId, LotName lotName, CoffeeType coffeeType, 
               ProcessingMethod processingMethod, Altitude altitude, Weight weight, Certifications certifications, Origin origin, String status) {
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
        this.status = status;
    }

    public Lot(CreateLotCommand command) {
        this.id = null; // Se asigna en la persistencia
        this.supplierId = command.supplierId();
        this.userId = command.userId();
        this.lotName = new LotName(command.lotName());
        this.coffeeType = new CoffeeType(command.coffeeType());
        this.processingMethod = new ProcessingMethod(command.processingMethod());
        this.altitude = new Altitude(command.altitude());
        this.weight = new Weight(command.weight());
        this.certifications = new Certifications(command.certifications());
        this.origin = new Origin(command.origin());
        this.status = command.status();
    }

    public Lot(UpdateLotCommand command) {
        this.id = command.lotId();
        this.supplierId = null; // No se actualiza el supplier en update
        this.userId = null; // No se actualiza el user en update
        this.lotName = new LotName(command.lotName());
        this.coffeeType = new CoffeeType(command.coffeeType());
        this.processingMethod = new ProcessingMethod(command.processingMethod());
        this.altitude = new Altitude(command.altitude());
        this.weight = new Weight(command.weight());
        this.certifications = new Certifications(command.certifications());
        this.origin = new Origin(command.origin());
        this.status = command.status();
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
    public String getStatus() { return status; }

    // Setters
    public void setLotName(LotName lotName) { this.lotName = lotName; }
    public void setCoffeeType(CoffeeType coffeeType) { this.coffeeType = coffeeType; }
    public void setProcessingMethod(ProcessingMethod processingMethod) { this.processingMethod = processingMethod; }
    public void setAltitude(Altitude altitude) { this.altitude = altitude; }
    public void setWeight(Weight weight) { this.weight = weight; }
    public void setCertifications(Certifications certifications) { this.certifications = certifications; }
    public void setOrigin(Origin origin) { this.origin = origin; }
    public void setStatus(String status) { this.status = status; }
} 