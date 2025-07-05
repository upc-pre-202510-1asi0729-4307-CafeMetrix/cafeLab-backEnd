package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

import java.time.LocalDateTime;

/**
 * Resource representing a cupping session.
 */
public record CuppingSessionResource(
        Long id,
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
}