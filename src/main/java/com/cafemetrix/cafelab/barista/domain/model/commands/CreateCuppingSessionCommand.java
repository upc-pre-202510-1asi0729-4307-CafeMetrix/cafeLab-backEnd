package com.cafemetrix.cafelab.barista.domain.model.commands;

import java.time.LocalDateTime;

public record CreateCuppingSessionCommand(
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
    public CreateCuppingSessionCommand {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Cupping Session name cannot be null or blank");
        if (origin == null || origin.isBlank())
            throw new IllegalArgumentException("Origin cannot be null or blank");
        if (variety == null || variety.isBlank())
            throw new IllegalArgumentException("Variety cannot be null or blank");
        if (processingMethod == null || processingMethod.isBlank())
            throw new IllegalArgumentException("Processing method cannot be null or blank");
        if (roastProfile == null || roastProfile.isBlank())
            throw new IllegalArgumentException("Roast profile cannot be null or blank");
        if (lotId == null || lotId <= 0)
            throw new IllegalArgumentException("LotId must be provided and greater than 0");
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("UserId must be provided and greater than 0");
        if (date == null)
            throw new IllegalArgumentException("Date cannot be null");
    }
}