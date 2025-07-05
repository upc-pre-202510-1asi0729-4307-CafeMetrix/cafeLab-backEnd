package com.cafemetrix.cafelab.preparation.domain.services;

import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Recipe;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateRecipeCommand;

import java.util.Optional;

/**
 * Recipe Command Service Interface
 */
public interface RecipeCommandService {
    Optional<Recipe> handle(CreateRecipeCommand command);
} 