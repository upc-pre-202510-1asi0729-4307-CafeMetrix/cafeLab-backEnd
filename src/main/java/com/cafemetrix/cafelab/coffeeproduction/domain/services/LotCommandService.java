package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateLotCommand;

public interface LotCommandService {
    Lot createLot(CreateLotCommand command);
    Lot updateLot(UpdateLotCommand command);
    boolean deleteLot(DeleteLotCommand command);
} 