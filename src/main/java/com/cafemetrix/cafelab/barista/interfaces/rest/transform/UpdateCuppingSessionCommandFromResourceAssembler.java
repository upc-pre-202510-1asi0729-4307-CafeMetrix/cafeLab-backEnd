package com.cafemetrix.cafelab.barista.interfaces.rest.transform;

import com.cafemetrix.cafelab.barista.domain.model.commands.UpdateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.UpdateCuppingSessionResource;

public class UpdateCuppingSessionCommandFromResourceAssembler {
    public static UpdateCuppingSessionCommand toCommandFromResource(Long id, UpdateCuppingSessionResource resource) {
        return new UpdateCuppingSessionCommand(
                id,
                resource.name(),
                resource.origin(),
                resource.variety(),
                resource.favorite()
        );
    }
}