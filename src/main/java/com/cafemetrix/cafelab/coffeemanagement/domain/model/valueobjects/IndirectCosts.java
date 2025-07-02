package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class IndirectCosts {
    private final TransportCost transportCost;
    private final StorageCost storageCost;
    private final ProcessingCost processingCost;
    private final OtherCosts otherCosts;

    public IndirectCosts(TransportCost transportCost, StorageCost storageCost, 
                        ProcessingCost processingCost, OtherCosts otherCosts) {
        this.transportCost = transportCost;
        this.storageCost = storageCost;
        this.processingCost = processingCost;
        this.otherCosts = otherCosts;
    }

    public TransportCost getTransportCost() { return transportCost; }
    public StorageCost getStorageCost() { return storageCost; }
    public ProcessingCost getProcessingCost() { return processingCost; }
    public OtherCosts getOtherCosts() { return otherCosts; }

    public double getTotalCost() {
        return transportCost.getTotalCost() + storageCost.getTotalCost() + 
               processingCost.getTotalCost() + otherCosts.getTotalCost();
    }
} 