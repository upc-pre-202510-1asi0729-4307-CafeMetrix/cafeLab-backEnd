package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transform;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateCoffeeLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.resources.UpdateCoffeeLotResource;

/**
 * Assembler for transforming UpdateCoffeeLotResource to UpdateCoffeeLotCommand
 */
public class UpdateCoffeeLotCommandFromResourceAssembler {
    public static UpdateCoffeeLotCommand toCommandFromResource(Long coffeeLotId, UpdateCoffeeLotResource resource) {
        return new UpdateCoffeeLotCommand(
            coffeeLotId,
            resource.lot_name(),
            resource.coffee_type(),
            resource.processing_method(),
            resource.altitude(),
            resource.weight(),
            resource.origin(),
            resource.status(),
            resource.certifications()
        );
    }
} 