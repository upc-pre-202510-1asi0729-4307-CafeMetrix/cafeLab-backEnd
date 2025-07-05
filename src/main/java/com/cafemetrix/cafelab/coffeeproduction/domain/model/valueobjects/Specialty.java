package com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects;

import java.util.List;

public record Specialty(List<String> values) {
    public Specialty {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Specialties cannot be null or empty");
        }
        if (values.size() > 10) {
            throw new IllegalArgumentException("Cannot have more than 10 specialties");
        }
        for (String specialty : values) {
            if (specialty == null || specialty.trim().isEmpty()) {
                throw new IllegalArgumentException("Specialty cannot be null or empty");
            }
            if (specialty.trim().length() > 100) {
                throw new IllegalArgumentException("Specialty cannot exceed 100 characters");
            }
        }
    }
} 