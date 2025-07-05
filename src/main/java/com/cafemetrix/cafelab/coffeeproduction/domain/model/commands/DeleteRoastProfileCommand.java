package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.RoastProfileId;

public record DeleteRoastProfileCommand(RoastProfileId roastProfileId) {
    public DeleteRoastProfileCommand {
        if (roastProfileId == null) {
            throw new IllegalArgumentException("RoastProfileId cannot be null");
        }
    }
} 