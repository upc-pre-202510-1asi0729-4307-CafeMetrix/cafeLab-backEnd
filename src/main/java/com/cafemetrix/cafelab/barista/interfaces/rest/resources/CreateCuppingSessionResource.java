package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

import com.cafemetrix.cafelab.barista.domain.model.valueobjects.CuppingSessionName;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffees.domain.model.valueobjects.CoffeeVariety;

import java.time.LocalDateTime;

/**
 * Resource for creating a cupping session.
 */
public record CreateCuppingSessionResource(
        CuppingSessionName cuppingSessionName,
        Origin origin,
        CoffeeVariety variety,
        ProcessingMethod processingMethod,
        Boolean favorite,
        ProfileName roastProfile,
        LotId lotId,
        UserId userId,
        LocalDateTime date
) {
    /**
     * Validates the resource.
     *
     * @throws IllegalArgumentException if the resource is invalid.
     */
    public CreateCuppingSessionResource {
        if (cuppingSessionName == null) throw new IllegalArgumentException("Name is required.");
        if (origin == null) throw new IllegalArgumentException("Origin is required.");
        if (variety == null) throw new IllegalArgumentException("Variety is required.");
        if (processingMethod == null)
            throw new IllegalArgumentException("Processing method is required.");
        if (favorite == null) throw new IllegalArgumentException("Favorite is required.");
        if (roastProfile == null) throw new IllegalArgumentException("Roast profile is required.");
        if (lotId == null) throw new IllegalArgumentException("Lot ID is required.");
        if (userId == null) throw new IllegalArgumentException("User ID is required.");
        if (date == null) throw new IllegalArgumentException("Date is required.");
    }
}