package com.cafemetrix.cafelab.barista.domain.model.aggregates;

import com.cafemetrix.cafelab.barista.domain.model.commands.CreateCuppingSessionCommand;
import com.cafemetrix.cafelab.barista.domain.model.commands.UpdateCuppingSessionCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffees.domain.model.valueobjects.CoffeeVariety;
import com.cafemetrix.cafelab.barista.domain.model.valueobjects.CuppingSessionName;
import com.cafemetrix.cafelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import javax.naming.Name;
import java.time.LocalDateTime;

/**
 * Cupping Session Aggregate Root
 * @summary
 * This aggregate root represents a cupping session log.
    * A cupping session is the record of a technique where the characteristics of a specific batch of coffee are evaluated.
 * @since 1.0
 */
@Getter
@Entity
public class CuppingSession extends AuditableAbstractAggregateRoot<CuppingSession> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "cupping_name"))
    private CuppingSessionName name;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "cupping_origin"))
    private Origin origin;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "cupping_variety"))
    private CoffeeVariety variety;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "processing_method"))
    private ProcessingMethod processingMethod;

    private boolean favorite;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "roast_profile"))
    private RoastProfileId roastProfile;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "lot_id"))
    private LotId lotId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_id"))
    private UserId userId;

    private LocalDateTime date;

    /**
     * Create a new Cupping Session
     */

    public CuppingSession() {
        this.date = LocalDateTime.now();
    }

    /**
     * Create a new cupping session with information from the command
     * @param command The command to create the cupping session
     * @see CreateCuppingSessionCommand
     */
    public CuppingSession(CreateCuppingSessionCommand command) {
        this.name = new CuppingSessionName(command.cuppingSessionName().name());
        this.origin = new Origin(command.origin().value());
        this.variety = new CoffeeVariety(command.variety().value());
        this.processingMethod = new ProcessingMethod(command.processingMethod().value());
        this.favorite = command.favorite();

        this.roastProfile = new RoastProfileId(command.roastProfile().value());
        this.lotId = new LotId(command.lotId().value());
        this.userId = new UserId(command.userId().value());
        this.date = command.date();
    }

    /**
     * Update the favorite status of a cupping session
     */

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
    public void updateFromCommand(UpdateCuppingSessionCommand command) {
        this.name = new CuppingSessionName(command.name());
        this.origin = new Origin(command.origin());
        this.variety = new CoffeeVariety(command.variety());
        this.favorite = command.favorite();
    }





}
