package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

import java.time.LocalDateTime;

/**
 * Resource for creating a cupping session.
 */
public record CreateCuppingSessionResource(
        String name,
        String origin,
        String variety,
        String processingMethod,
        Boolean favorite,
        String roastProfile,
        Long lotId,
        Long userId,
        LocalDateTime date
) {
    public CreateCuppingSessionResource {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required.");
        if (origin == null || origin.isBlank()) throw new IllegalArgumentException("Origin is required.");
        if (variety == null || variety.isBlank()) throw new IllegalArgumentException("Variety is required.");
        if (processingMethod == null || processingMethod.isBlank())
            throw new IllegalArgumentException("Processing method is required.");
        if (favorite == null) throw new IllegalArgumentException("Favorite is required.");
        if (roastProfile == null || roastProfile.isBlank()) throw new IllegalArgumentException("Roast profile is required.");
        if (lotId == null || lotId <= 0) throw new IllegalArgumentException("Lot ID is required.");
        if (userId == null || userId <= 0) throw new IllegalArgumentException("User ID is required.");
        if (date == null) throw new IllegalArgumentException("Date is required.");
    }
}