package com.cafemetrix.cafelab.barista.domain.model.commands;

public record DeleteCuppingSessionCommand(Long cuppingSessionId) {
    public DeleteCuppingSessionCommand {
        if (cuppingSessionId == null || cuppingSessionId <= 0) {
            throw new IllegalArgumentException("CuppingSessionId must be valid");
        }
    }
}