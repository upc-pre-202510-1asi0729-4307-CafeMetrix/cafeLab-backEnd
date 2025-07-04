package com.cafemetrix.cafelab.preparation.domain.model.aggregates;

import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateIngredientCommand;
import com.cafemetrix.cafelab.preparation.domain.model.valueobjects.IngredientName;
import com.cafemetrix.cafelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Ingredient Aggregate Root
 */
@Entity
public class Ingredient extends AuditableAbstractAggregateRoot<Ingredient> {

    /**
     * -- GETTER --
     * ID de la receta a la que pertenece
     */
    @Getter
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "name", length = 100))
    private IngredientName name;

    /**
     * -- GETTER --
     * Cantidad del ingrediente
     */
    @Getter
    @Column(nullable = false)
    private Double amount;

    @Column(length = 10, nullable = false)
    private String unit;

    /**
     * Constructor por defecto
     */
    public Ingredient() {}

    /**
     * Constructor principal
     */
    public Ingredient(Long recipeId, String name, Double amount, String unit) {
        this.recipeId = recipeId;
        this.name = new IngredientName(name);
        this.amount = amount;
        this.unit = unit;
    }

    /**
     * Constructor con comando
     */
    public Ingredient(CreateIngredientCommand command) {
        this.recipeId = command.recipeId();
        this.name = new IngredientName(command.name());
        this.amount = command.amount();
        this.unit = command.unit();
    }

    /**
     * Nombre del ingrediente
     */
    public String getName() {
        return name.value();
    }

    /**
     * Unidad de medida
     */
    public String getUnit() {
        return unit;
    }
} 