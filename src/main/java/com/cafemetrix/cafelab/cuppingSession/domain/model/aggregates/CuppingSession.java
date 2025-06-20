package com.cafemetrix.cafelab.cuppingSession.domain.model.aggregates;

import com.cafemetrix.cafelab.cuppingSession.domain.model.commands.CreateCuppingSessionCommand;
import com.cafemetrix.cafelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;

/**
 * CuppingSession aggregate root
 *
 * @summary
 * This aggregate root represents a cupping session, which includes data
 * related to the evaluation of a coffee lot by a user.
 *
 * @since 1.0
 */
@Getter
@Entity
public class CuppingSession extends AuditableAbstractAggregateRoot<CuppingSession> {
    private Long userId;
    private String name;
    private LocalDate date;
    private String origin;
    private String variety;
    private String processing;
    private String roastProfile;
    private Long lotId;
    private boolean isFavorite;

    public CuppingSession() {
        this.userId = 0L;
        this.name = Strings.EMPTY;
        this.date = LocalDate.now();
        this.origin = Strings.EMPTY;
        this.variety = Strings.EMPTY;
        this.processing = Strings.EMPTY;
        this.roastProfile = Strings.EMPTY;
        this.lotId = 0L;
        this.isFavorite = false;
    }

    public CuppingSession(CreateCuppingSessionCommand command) {
        this.userId = command.userId();
        this.name = command.name();
        this.date = LocalDate.now(); // se asigna automáticamente
        this.origin = Strings.EMPTY;
        this.variety = Strings.EMPTY;
        this.processing = Strings.EMPTY;
        this.roastProfile = command.roastProfile();
        this.lotId = command.lotId();
        this.isFavorite = false;
    }

    public CuppingSession updateInformation(String name, String roastProfile, Long lotId) {
        this.name = name;
        this.roastProfile = roastProfile;
        this.lotId = lotId;
        return this;
    }

    public void markAsFavorite() {
        this.isFavorite = true;
    }

    public void unmarkAsFavorite() {
        this.isFavorite = false;
    }

    public void updateMetadata(String origin, String variety, String processing) {
        this.origin = origin;
        this.variety = variety;
        this.processing = processing;
    }
}