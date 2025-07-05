package com.cafemetrix.cafelab.barista.application.internal.queryservices;

import com.cafemetrix.cafelab.barista.domain.model.aggregates.CuppingSession;
import com.cafemetrix.cafelab.barista.domain.model.queries.GetAllCuppingSessionsQuery;
import com.cafemetrix.cafelab.barista.domain.model.queries.GetCuppingSessionByIdQuery;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionQueryService;
import com.cafemetrix.cafelab.barista.infrastructure.persistence.jpa.repositories.CuppingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the CuppingSessionQueryService interface.
 * <p>This service is responsible for handling read operations related to CuppingSession aggregate.</p>
 *
 * @see CuppingSessionQueryService
 * @see CuppingSessionRepository
 */
@Service
public class CuppingSessionQueryServiceImpl implements CuppingSessionQueryService {

    private final CuppingSessionRepository cuppingSessionRepository;

    /**
     * Constructor
     * @param cuppingSessionRepository the repository for cupping sessions
     */
    public CuppingSessionQueryServiceImpl(CuppingSessionRepository cuppingSessionRepository) {
        this.cuppingSessionRepository = cuppingSessionRepository;
    }

    // inherit javadoc
    @Override
    public Optional<CuppingSession> handle(GetCuppingSessionByIdQuery query) {
        return cuppingSessionRepository.findById(query.cuppingSessionId());
    }

    // inherit javadoc
    @Override
    public List<CuppingSession> handle(GetAllCuppingSessionsQuery query) {
        return cuppingSessionRepository.findAllByUserIdValue(query.userId().value());
    }
}