package com.cafemetrix.cafelab.preparation.application.acl;

import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Ingredient;
import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Portfolio;
import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Recipe;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateIngredientCommand;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreatePortfolioCommand;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateRecipeCommand;
import com.cafemetrix.cafelab.preparation.domain.model.queries.*;
import com.cafemetrix.cafelab.preparation.domain.services.*;
import com.cafemetrix.cafelab.preparation.interfaces.acl.PreparationContextFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of Preparation Context Facade
 */
@Service
public class PreparationContextFacadeImpl implements PreparationContextFacade {
    private final RecipeCommandService recipeCommandService;
    private final RecipeQueryService recipeQueryService;
    private final IngredientCommandService ingredientCommandService;
    private final IngredientQueryService ingredientQueryService;
    private final PortfolioCommandService portfolioCommandService;
    private final PortfolioQueryService portfolioQueryService;

    public PreparationContextFacadeImpl(
            RecipeCommandService recipeCommandService,
            RecipeQueryService recipeQueryService,
            IngredientCommandService ingredientCommandService,
            IngredientQueryService ingredientQueryService,
            PortfolioCommandService portfolioCommandService,
            PortfolioQueryService portfolioQueryService) {
        this.recipeCommandService = recipeCommandService;
        this.recipeQueryService = recipeQueryService;
        this.ingredientCommandService = ingredientCommandService;
        this.ingredientQueryService = ingredientQueryService;
        this.portfolioCommandService = portfolioCommandService;
        this.portfolioQueryService = portfolioQueryService;
    }

    @Override
    public Long createRecipe(Long userId, String name, String imageUrl, String extractionMethod,
                           String ratio, Long cuppingSessionId, Long portfolioId, Integer preparationTime,
                           String steps, String tips, String cupping, String grindSize) {
        var command = new CreateRecipeCommand(userId, name, imageUrl, extractionMethod, ratio,
                cuppingSessionId, portfolioId, preparationTime, steps, tips, cupping, grindSize);
        return recipeCommandService.handle(command).getId();
        return recipe.map(Recipe::getId).orElse(0L);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeQueryService.handle(new GetAllRecipesQuery());
    }

    @Override
    public Optional<Recipe> getRecipeById(Long recipeId) {
        return recipeQueryService.handle(recipeId);
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        // Primero eliminamos los ingredientes asociados
        var ingredients = ingredientQueryService.handle(recipeId);
        ingredients.forEach(ingredient -> 
            ingredientCommandService.delete(ingredient.getId())
        );
        // Luego eliminamos la receta
        recipeCommandService.delete(recipeId);
    }

    @Override
    public Long createIngredient(Long recipeId, String name, Double amount, String unit) {
        var command = new CreateIngredientCommand(recipeId, name, amount, unit);
        return ingredientCommandService.handle(command).getId();
    }

    @Override
    public List<Ingredient> getIngredientsByRecipeId(Long recipeId) {
        return ingredientQueryService.handle(recipeId);
    }

    @Override
    public Long createPortfolio(Long userId, String name) {
        var createPortfolioCommand = new CreatePortfolioCommand(userId, name);
        return portfolioCommandService.handle(createPortfolioCommand);
    }

    @Override
    public List<Portfolio> getAllPortfolios() {
        return portfolioQueryService.handle();
    }

    @Override
    public Optional<Portfolio> getPortfolioById(Long portfolioId) {
        return portfolioQueryService.handle(portfolioId);
    }

    @Override
    public List<Portfolio> getPortfoliosByUserId(Long userId) {
        return portfolioQueryService.handleByUserId(userId);
    }
} 