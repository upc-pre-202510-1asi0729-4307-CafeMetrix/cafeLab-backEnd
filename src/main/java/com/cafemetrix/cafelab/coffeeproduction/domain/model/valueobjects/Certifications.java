package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

import java.util.List;

public record Certifications(List<String> values) {
    public Certifications {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Certifications cannot be null or empty");
        }
        if (values.size() > 10) {
            throw new IllegalArgumentException("Cannot have more than 10 certifications");
        }
        for (String certification : values) {
            if (certification == null || certification.trim().isEmpty()) {
                throw new IllegalArgumentException("Certification cannot be null or empty");
            }
            if (certification.trim().length() > 100) {
                throw new IllegalArgumentException("Certification cannot exceed 100 characters");
            }
        }
    }
} 