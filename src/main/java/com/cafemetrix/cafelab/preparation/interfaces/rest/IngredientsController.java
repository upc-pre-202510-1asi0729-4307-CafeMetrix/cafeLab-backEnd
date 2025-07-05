package com.cafemetrix.cafelab.preparation.interfaces.rest;

import com.cafemetrix.cafelab.preparation.interfaces.acl.PreparationContextFacade;
import com.cafemetrix.cafelab.preparation.interfaces.rest.resources.*;
import com.cafemetrix.cafelab.shared.interfaces.rest.resources.MessageResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/recipes/{recipeId}/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Recipes", description = "Recipe Ingredients Management Endpoints")
public class IngredientsController {
    private final PreparationContextFacade preparationContextFacade;

    public IngredientsController(PreparationContextFacade preparationContextFacade) {
        this.preparationContextFacade = preparationContextFacade;
    }

    @PostMapping
    public ResponseEntity<?> addIngredientToRecipe(
            @PathVariable Long recipeId,
            @RequestBody CreateIngredientResource resource) {
        
        if (!recipeId.equals(resource.recipeId())) {
            return ResponseEntity.badRequest()
                .body(new MessageResource("El ID de la receta no coincide con el de la ruta"));
        }

        var ingredientId = preparationContextFacade.createIngredient(
            resource.recipeId(), resource.name(),
            resource.amount(), resource.unit()
        );

        if (ingredientId == 0L) {
            return ResponseEntity.badRequest()
                .body(new MessageResource("No se pudo crear el ingrediente"));
        }

        var ingredients = preparationContextFacade.getIngredientsByRecipeId(recipeId);
        var ingredient = ingredients.stream()
            .filter(i -> i.getId().equals(ingredientId))
            .findFirst();

        if (ingredient.isEmpty()) {
            return ResponseEntity.badRequest()
                .body(new MessageResource("No se pudo obtener el ingrediente creado"));
        }

        var ingredientResource = new IngredientResource(
            ingredient.get().getId(),
            ingredient.get().getRecipeId(),
            ingredient.get().getName(),
            ingredient.get().getAmount(),
            ingredient.get().getUnit()
        );

        return new ResponseEntity<>(ingredientResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IngredientResource>> getIngredientsByRecipeId(@PathVariable Long recipeId) {
        var ingredients = preparationContextFacade.getIngredientsByRecipeId(recipeId);
        var ingredientResources = ingredients.stream()
            .map(ingredient -> new IngredientResource(
                ingredient.getId(),
                ingredient.getRecipeId(),
                ingredient.getName(),
                ingredient.getAmount(),
                ingredient.getUnit()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(ingredientResources);
    }
} 