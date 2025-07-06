package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateRoastProfileCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteRoastProfileCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateRoastProfileCommand;

import java.util.Optional;

/**
 * RoastProfile Command Service Interface
 */
public interface RoastProfileCommandService {
    Optional<RoastProfile> handle(CreateRoastProfileCommand command);
    Optional<RoastProfile> handle(UpdateRoastProfileCommand command);
    boolean handle(DeleteRoastProfileCommand command);
} 