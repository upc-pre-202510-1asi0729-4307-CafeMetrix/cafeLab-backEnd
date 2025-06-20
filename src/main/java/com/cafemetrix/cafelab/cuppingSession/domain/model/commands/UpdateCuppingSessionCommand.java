package com.cafemetrix.cafelab.cuppingSession.domain.model.commands;

/**
 * Command to update a cupping session's basic information
 * @param name new name. Cannot be null or blank.
 * @param roastProfile new roast profile. Cannot be null or blank.
 * @param lotId new associated lot ID. Must be positive.
 */
public record UpdateCuppingSessionCommand(String name, String roastProfile, Long lotId) {
    public UpdateCuppingSessionCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if (roastProfile == null || roastProfile.isBlank()) {
            throw new IllegalArgumentException("roastProfile cannot be null or blank");
        }
        if (lotId == null || lotId <= 0) {
            throw new IllegalArgumentException("lotId must be positive");
        }
    }
}