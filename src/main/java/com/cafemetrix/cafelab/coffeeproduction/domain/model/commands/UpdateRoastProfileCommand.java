package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.RoastProfileId;

public record UpdateRoastProfileCommand(
    RoastProfileId roastProfileId,
    String name,
    String type,
    int duration,
    double tempInitial,
    double tempFinal,
    boolean isFavorite,
    Long lot,
    double tempStart,
    double tempEnd
) {
    public UpdateRoastProfileCommand {
        if (roastProfileId == null) {
            throw new IllegalArgumentException("RoastProfileId cannot be null");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        if (tempInitial < -50 || tempInitial > 300) {
            throw new IllegalArgumentException("Initial temperature must be between -50 and 300°C");
        }
        if (tempFinal < -50 || tempFinal > 300) {
            throw new IllegalArgumentException("Final temperature must be between -50 and 300°C");
        }
        if (lot == null) {
            throw new IllegalArgumentException("Lot cannot be null");
        }
        if (tempStart < -50 || tempStart > 300) {
            throw new IllegalArgumentException("Start temperature must be between -50 and 300°C");
        }
        if (tempEnd < -50 || tempEnd > 300) {
            throw new IllegalArgumentException("End temperature must be between -50 and 300°C");
        }
    }
} 