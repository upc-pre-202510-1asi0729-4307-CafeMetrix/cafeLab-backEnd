package com.cafemetrix.cafelab.barista.domain.model.commands;

import java.time.LocalDateTime;

public record UpdateCuppingSessionCommand(
        Long cuppingSessionId,
        String name,
        Boolean favorite,
        LocalDateTime date
) {
    public UpdateCuppingSessionCommand {
        if (cuppingSessionId == null || cuppingSessionId <= 0)
            throw new IllegalArgumentException("CuppingSessionId must be valid");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        if (date == null)
            throw new IllegalArgumentException("Date cannot be null");
    }
}