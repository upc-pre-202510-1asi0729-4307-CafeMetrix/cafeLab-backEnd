package com.cafemetrix.cafelab.barista.domain.model.commands;

public record UpdateCuppingSessionCommand(
        Long cuppingSessionId,
        String name,
        String origin,
        String variety,
        Boolean favorite
) {
    public UpdateCuppingSessionCommand {
        if (cuppingSessionId == null || cuppingSessionId <= 0)
            throw new IllegalArgumentException("CuppingSessionId must be valid");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        if (origin == null || origin.isBlank())
            throw new IllegalArgumentException("Origin cannot be null or blank");
        if (variety == null || variety.isBlank())
            throw new IllegalArgumentException("Variety cannot be null or blank");
    }
}