package com.cafemetrix.cafelab.cuppingSession.domain.model.commands;

/**
 * Command to delete a cupping session
 * @param sessionId the ID of the cupping session to delete. Must be positive.
 */
public record DeleteCuppingSessionCommand(Long sessionId) {
    public DeleteCuppingSessionCommand {
        if (sessionId == null || sessionId <= 0) {
            throw new IllegalArgumentException("sessionId must be positive");
        }
    }
}
