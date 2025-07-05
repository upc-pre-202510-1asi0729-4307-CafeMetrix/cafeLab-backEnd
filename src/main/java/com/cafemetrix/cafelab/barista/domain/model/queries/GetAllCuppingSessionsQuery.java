package com.cafemetrix.cafelab.barista.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;

/**
 * Query to get all cupping sessions of a user.
 * @param userId The ID of the user.
 */
public record GetAllCuppingSessionsQuery(UserId userId) {
    public GetAllCuppingSessionsQuery {
        if (userId == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
    }
}