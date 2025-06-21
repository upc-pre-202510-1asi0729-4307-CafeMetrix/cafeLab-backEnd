package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;

public record DeleteLotCommand(LotId lotId) {
    public DeleteLotCommand {
        if (lotId == null) {
            throw new IllegalArgumentException("LotId cannot be null");
        }
    }
} 