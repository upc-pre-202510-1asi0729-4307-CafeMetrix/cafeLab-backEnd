package com.cafemetrix.cafelab.barista.domain.model.queries;

/**
 * Query to get a cupping session by its ID.
 * @param cuppingSessionId The ID of the cupping session.
 */
public record GetCuppingSessionByIdQuery(Long cuppingSessionId) {
    /**
     * Constructor validation
     */
    public GetCuppingSessionByIdQuery {
        if (cuppingSessionId == null || cuppingSessionId <= 0) {
            throw new IllegalArgumentException("CuppingSessionId must be greater than 0 and not null");
        }
    }
}