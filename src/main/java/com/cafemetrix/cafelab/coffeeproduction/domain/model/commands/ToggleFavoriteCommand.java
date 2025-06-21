package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.RoastProfileId;

public record ToggleFavoriteCommand(RoastProfileId roastProfileId) {
    public ToggleFavoriteCommand {
        if (roastProfileId == null) {
            throw new IllegalArgumentException("RoastProfileId cannot be null");
        }
    }
} 