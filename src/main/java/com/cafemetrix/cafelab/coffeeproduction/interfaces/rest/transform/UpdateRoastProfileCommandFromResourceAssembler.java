package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transform;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateRoastProfileCommand;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.resources.UpdateRoastProfileResource;

/**
 * Assembler for transforming UpdateRoastProfileResource to UpdateRoastProfileCommand
 */
public class UpdateRoastProfileCommandFromResourceAssembler {
    public static UpdateRoastProfileCommand toCommandFromResource(Long roastProfileId, UpdateRoastProfileResource resource) {
        return new UpdateRoastProfileCommand(
            roastProfileId,
            resource.name(),
            resource.type(),
            resource.duration(),
            resource.tempStart(),
            resource.tempEnd(),
            resource.lot(),
            resource.isFavorite()
        );
    }
} 