package com.cafemetrix.cafelab.barista.infrastructure.persistence.jpa.repositories;

import com.cafemetrix.cafelab.barista.domain.model.aggregates.CuppingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * CuppingSessionRepository
 * <p>This interface is used to interact with the database and perform
 * CRUD and business-related command and query operations on the CuppingSession aggregate.</p>
 *
 * @see CuppingSession
 * @since 1.0
 */
@Repository
public interface CuppingSessionRepository extends JpaRepository<CuppingSession, Long> {

    /**
     * Find a cupping session by its name
     *
     * @param name The name of the cupping session
     * @return An Optional of the cupping session
     */
    Optional<CuppingSession> findByNameValue(String name);

    /**
     * Find all cupping sessions by user id
     *
     * @param userId The id of the user (as Long)
     * @return A list of cupping sessions belonging to the user
     */
    List<CuppingSession> findAllByUserIdValue(Long userId);

    /**
     * Check if a cupping session exists by its name
     *
     * @param name The name of the cupping session
     * @return True if the session exists, false otherwise
     */
    boolean existsByNameValue(String name);

    /**
     * Check if a cupping session exists by name excluding a specific id
     *
     * @param name The name of the cupping session
     * @param id The id to exclude from the check
     * @return True if another session with the same name exists, false otherwise
     */
    boolean existsByNameValueAndIdIsNot(String name, Long id);
}