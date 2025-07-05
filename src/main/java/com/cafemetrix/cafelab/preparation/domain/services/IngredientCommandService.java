package com.cafemetrix.cafelab.preparation.domain.services;

import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Ingredient;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateIngredientCommand;

import java.util.Optional;

/**
 * Ingredient Command Service Interface
 */
public interface IngredientCommandService {
    Optional<Ingredient> handle(CreateIngredientCommand command);
} 