package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.CoffeeLot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateCoffeeLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteCoffeeLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateCoffeeLotCommand;

import java.util.Optional;

/**
 * CoffeeLot Command Service Interface
 */
public interface CoffeeLotCommandService {
    Optional<CoffeeLot> handle(CreateCoffeeLotCommand command);
    Optional<CoffeeLot> handle(UpdateCoffeeLotCommand command);
    boolean handle(DeleteCoffeeLotCommand command);
} 