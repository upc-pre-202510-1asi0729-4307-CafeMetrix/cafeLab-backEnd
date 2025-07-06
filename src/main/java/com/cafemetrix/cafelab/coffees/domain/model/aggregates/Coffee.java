package com.cafemetrix.cafelab.coffees.domain.model.aggregates;

import com.cafemetrix.cafelab.coffees.domain.model.commands.CreateCoffeeCommand;
import com.cafemetrix.cafelab.coffees.domain.model.valueobjects.CoffeeName;
import com.cafemetrix.cafelab.coffees.domain.model.valueobjects.CoffeeRegion;
import com.cafemetrix.cafelab.coffees.domain.model.valueobjects.CoffeeVariety;
import com.cafemetrix.cafelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Coffee Aggregate Root
 */
@Entity
public class Coffee extends AuditableAbstractAggregateRoot<Coffee> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private CoffeeName name;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "region"))
    private CoffeeRegion region;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "variety"))
    private CoffeeVariety variety;


    @Column(name = "user_id")
    private Long userId;

    // Getter y Setter
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    /**
     * -- GETTER --
     *  Peso total del café
     */
    @Getter
    @Column(nullable = false)
    private Double totalWeight;

    /**
     * Constructor principal con value objects
     */
    public Coffee(String name, String region, String variety, Double totalWeight, Long userId) {
        this.name = new CoffeeName(name);
        this.region = new CoffeeRegion(region);
        this.variety = new CoffeeVariety(variety);
        this.totalWeight = totalWeight;
        this.userId = userId;
    }

    /**
     * Constructor por defecto
     */
    public Coffee() {}

    /**
     * Constructor con comando
     */
    public Coffee(CreateCoffeeCommand command) {
        this.name = new CoffeeName(command.name());
        this.region = new CoffeeRegion(command.region());
        this.variety = new CoffeeVariety(command.variety());
        this.totalWeight = command.totalWeight();
        this.userId = command.userId();
    }

    /**
     * Nombre del café
     */
    public String getName() {
        return name.value();
    }

    /**
     * Región del café
     */
    public String getRegion() {
        return region.value();
    }

    /**
     * Variedad del café
     */
    public String getVariety() {
        return variety.value();
    }

    /**
     * Actualizar nombre
     */
    public void updateName(String name) {
        this.name = new CoffeeName(name);
    }

    /**
     * Actualizar región
     */
    public void updateRegion(String region) {
        this.region = new CoffeeRegion(region);
    }

    /**
     * Actualizar variedad
     */
    public void updateVariety(String variety) {
        this.variety = new CoffeeVariety(variety);
    }

    /**
     * Actualizar peso total
     */
    public void updateTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }
}