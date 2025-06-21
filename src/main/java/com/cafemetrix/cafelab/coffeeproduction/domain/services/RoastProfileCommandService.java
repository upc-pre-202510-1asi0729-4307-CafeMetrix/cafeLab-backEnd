package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.*;

public interface RoastProfileCommandService {
    RoastProfile createRoastProfile(CreateRoastProfileCommand command);
    RoastProfile updateRoastProfile(UpdateRoastProfileCommand command);
    boolean deleteRoastProfile(DeleteRoastProfileCommand command);
    RoastProfile toggleFavorite(ToggleFavoriteCommand command);
    RoastProfile duplicateRoastProfile(DuplicateRoastProfileCommand command);
} 