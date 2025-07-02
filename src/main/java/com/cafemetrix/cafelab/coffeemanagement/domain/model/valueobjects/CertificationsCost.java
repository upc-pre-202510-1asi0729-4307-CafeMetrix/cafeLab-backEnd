package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

public record CertificationsCost(Double value) {
    public CertificationsCost {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Certifications cost must be non-negative");
        }
    }
} 