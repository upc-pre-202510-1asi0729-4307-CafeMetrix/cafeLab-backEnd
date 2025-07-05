package com.cafemetrix.cafelab.barista.domain.services;

import com.cafemetrix.cafelab.barista.domain.model.aggregates.CuppingSession;
import com.cafemetrix.cafelab.barista.domain.model.queries.GetAllCuppingSessionsQuery;
import com.cafemetrix.cafelab.barista.domain.model.queries.GetCuppingSessionByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * CuppingSessionQueryService
 * <p>Service that handles cupping session queries.</p>
 */
public interface CuppingSessionQueryService {
    /**
     * Handle a get cupping session by id query
     * @param query The query containing the cupping session id
     * @return The cupping session, if found
     * @see GetCuppingSessionByIdQuery
     */
    Optional<CuppingSession> handle(GetCuppingSessionByIdQuery query);

    /**
     * Handle a get all cupping sessions query
     * @param query The query containing the user id
     * @return The list of cupping sessions for the user
     * @see GetAllCuppingSessionsQuery
     */
    List<CuppingSession> handle(GetAllCuppingSessionsQuery query);
}