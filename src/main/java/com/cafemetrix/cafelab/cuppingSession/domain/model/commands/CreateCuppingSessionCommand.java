package com.cafemetrix.cafelab.cuppingSession.domain.model.commands;

/**
 * Command to create a cupping session
 * @param userId the ID of the user creating the session. Must be positive.
 * @param name the name of the cupping session. Cannot be null or blank.
 * @param roastProfile the roast profile. Cannot be null or blank.
 * @param lotId the associated lot ID. Must be positive.
 */
public record CreateCuppingSessionCommand(Long userId, String name, String roastProfile, Long lotId) {
    public CreateCuppingSessionCommand {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("userId must be positive");
        }
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