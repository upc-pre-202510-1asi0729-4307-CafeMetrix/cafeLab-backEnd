package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public class OtherCosts {
    private final QualityControlCost qualityControlCost;
    private final CertificationsCost certificationsCost;
    private final InsuranceCost insuranceCost;
    private final AdministrativeCost administrativeCost;

    public OtherCosts(QualityControlCost qualityControlCost, CertificationsCost certificationsCost,
                     InsuranceCost insuranceCost, AdministrativeCost administrativeCost) {
        this.qualityControlCost = qualityControlCost;
        this.certificationsCost = certificationsCost;
        this.insuranceCost = insuranceCost;
        this.administrativeCost = administrativeCost;
    }

    public QualityControlCost getQualityControlCost() { return qualityControlCost; }
    public CertificationsCost getCertificationsCost() { return certificationsCost; }
    public InsuranceCost getInsuranceCost() { return insuranceCost; }
    public AdministrativeCost getAdministrativeCost() { return administrativeCost; }

    public double getTotalCost() {
        return qualityControlCost.value() + certificationsCost.value() + 
               insuranceCost.value() + administrativeCost.value();
    }
} 