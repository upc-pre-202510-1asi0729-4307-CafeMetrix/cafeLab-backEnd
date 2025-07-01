package com.cafemetrix.cafelab.barista.application.internal.commandservices;

import com.cafemetrix.cafelab.barista.domain.model.aggregates.CuppingSession;
import com.cafemetrix.cafelab.barista.domain.model.commands.CreateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.domain.model.commands.UpdateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.domain.model.commands.DeleteCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionCommandService;
import com.cafemetrix.cafelab.barista.infrastructure.persistence.jpa.repositories.CuppingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the CuppingSessionCommandService interface.
 * <p>Handles create, update and delete operations for cupping sessions.</p>
 */
@Service
public class CuppingSessionCommandServiceImpl implements CuppingSessionCommandService {

    private final CuppingSessionRepository cuppingSessionRepository;

    public CuppingSessionCommandServiceImpl(CuppingSessionRepository cuppingSessionRepository) {
        this.cuppingSessionRepository = cuppingSessionRepository;
    }

    @Override
    public Long handle(CreateCuppingSessionCommand command) {
        var session = new CuppingSession(command);
        try {
            cuppingSessionRepository.save(session);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving cupping session: " + e.getMessage());
        }
        return session.getId();
    }

    @Override
    public Optional<CuppingSession> handle(UpdateCuppingSessionCommand command) {
        var result = cuppingSessionRepository.findById(command.cuppingSessionId());
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Cupping session with id %s not found".formatted(command.cuppingSessionId()));
        }

        var sessionToUpdate = result.get();

        sessionToUpdate.setFavorite(command.favorite());

        try {
            cuppingSessionRepository.save(sessionToUpdate);
            return Optional.of(sessionToUpdate);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating cupping session: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteCuppingSessionCommand command) {
        if (!cuppingSessionRepository.existsById(command.cuppingSessionId())) {
            throw new IllegalArgumentException("Cupping session with id %s not found".formatted(command.cuppingSessionId()));
        }

        try {
            cuppingSessionRepository.deleteById(command.cuppingSessionId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error deleting cupping session: " + e.getMessage());
        }
    }
}