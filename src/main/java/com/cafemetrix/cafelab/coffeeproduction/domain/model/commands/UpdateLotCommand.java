package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;

import java.util.List;

public record UpdateLotCommand(
    LotId lotId,
    String lotName,
    String coffeeType,
    String processingMethod,
    String altitude,
    String weight,
    List<String> certifications,
    String origin
) {
    public UpdateLotCommand {
        if (lotId == null) {
            throw new IllegalArgumentException("LotId cannot be null");
        }
        if (lotName == null || lotName.trim().isEmpty()) {
            throw new IllegalArgumentException("Lot name cannot be null or empty");
        }
        if (coffeeType == null || coffeeType.trim().isEmpty()) {
            throw new IllegalArgumentException("Coffee type cannot be null or empty");
        }
        if (processingMethod == null || processingMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("Processing method cannot be null or empty");
        }
        if (altitude == null || altitude.trim().isEmpty()) {
            throw new IllegalArgumentException("Altitude cannot be null or empty");
        }
        if (weight == null || weight.trim().isEmpty()) {
            throw new IllegalArgumentException("Weight cannot be null or empty");
        }
        if (certifications == null || certifications.isEmpty()) {
            throw new IllegalArgumentException("Certifications cannot be null or empty");
        }
        if (origin == null || origin.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin cannot be null or empty");
        }
    }
} 