package com.cafemetrix.cafelab.barista.interfaces.rest.transform;

import com.cafemetrix.cafelab.barista.domain.model.commands.CreateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.CreateCuppingSessionResource;

public class CreateCuppingSessionCommandFromResourceAssembler {

    public static CreateCuppingSessionCommand toCommandFromResource(CreateCuppingSessionResource resource) {
        return new CreateCuppingSessionCommand(
                resource.name(),
                resource.origin(),
                resource.variety(),
                resource.processingMethod(),
                resource.favorite(),
                resource.roastProfile(),
                resource.lotId(),
                resource.userId(),
                resource.date()
        );
    }
}