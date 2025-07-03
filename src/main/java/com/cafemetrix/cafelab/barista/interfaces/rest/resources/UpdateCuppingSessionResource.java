package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

public record UpdateCuppingSessionResource(
        String name,
        String origin,
        String variety,
        Boolean favorite
) {
    public UpdateCuppingSessionResource {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (origin == null || origin.isBlank()) throw new IllegalArgumentException("Origin is required");
        if (variety == null || variety.isBlank()) throw new IllegalArgumentException("Variety is required");
    }
}