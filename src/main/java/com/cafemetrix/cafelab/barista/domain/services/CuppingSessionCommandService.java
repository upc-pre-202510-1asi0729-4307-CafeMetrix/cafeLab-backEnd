package com.cafemetrix.cafelab.barista.domain.services;

import com.cafemetrix.cafelab.barista.domain.model.aggregates.CuppingSession;
import com.cafemetrix.cafelab.barista.domain.model.commands.CreateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.domain.model.commands.UpdateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.domain.model.commands.DeleteCuppingSessionCommand;

import java.util.Optional;

/**
 * CuppingSessionCommandService
 * Service that handles commands for creating, updating, and deleting cupping sessions.
 */
public interface CuppingSessionCommandService {

    /**
     * Handles the creation of a new cupping session
     * @param command the create command containing session data
     * @return the ID of the created cupping session
     */
    Long handle(CreateCuppingSessionCommand command);

    /**
     * Handles the update of an existing cupping session
     * @param command the update command
     * @return the updated cupping session, if found
     */
    Optional<CuppingSession> handle(UpdateCuppingSessionCommand command);

    /**
     * Handles the deletion of a cupping session
     * @param command the delete command
     */
    void handle(DeleteCuppingSessionCommand command);
}