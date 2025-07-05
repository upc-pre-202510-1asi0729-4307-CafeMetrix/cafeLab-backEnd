package com.cafemetrix.cafelab.barista.interfaces.rest.transform;

import com.cafemetrix.cafelab.barista.domain.model.commands.CreateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.CreateCuppingSessionResource;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffees.domain.model.commands.CreateCoffeeCommand;
import com.cafemetrix.cafelab.coffees.interfaces.rest.resources.CreateCoffeeResource;

/**
 * Assembler to convert a CreateCuppingSessionResource to a CreateCuppingSessionCommand.
 */
public class CreateCuppingSessionCommandFromResourceAssembler {
    /**
     * Converts a CreateCuppingSessionResource to a CreateCuppingSessionCommand.
     * @param resource The {@link CreateCuppingSessionResource} resource to convert.
     * @return The {@link CreateCuppingSessionCommand} command.
     */
    public static CreateCuppingSessionCommand toCommandFromResource(CreateCuppingSessionResource resource, UserId userId) {
        return new CreateCuppingSessionCommand(
                resource.cuppingSessionName(),
                resource.origin(),
                resource.variety(),
                resource.processingMethod(),
                resource.favorite(),
                resource.roastProfile(),
                resource.lotId(),
                userId,
                resource.date()
        );
    }
}