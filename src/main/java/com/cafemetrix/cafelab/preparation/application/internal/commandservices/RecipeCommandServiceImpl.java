package com.cafemetrix.cafelab.preparation.application.internal.commandservices;

import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Recipe;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateRecipeCommand;
import com.cafemetrix.cafelab.preparation.domain.services.RecipeCommandService;
import com.cafemetrix.cafelab.preparation.infrastructure.persistence.jpa.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeCommandServiceImpl implements RecipeCommandService {
    private final RecipeRepository recipeRepository;

    public RecipeCommandServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Optional<Recipe> handle(CreateRecipeCommand command) {
        try {
            var recipe = new Recipe(command);
            return Optional.of(recipeRepository.save(recipe));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
} 