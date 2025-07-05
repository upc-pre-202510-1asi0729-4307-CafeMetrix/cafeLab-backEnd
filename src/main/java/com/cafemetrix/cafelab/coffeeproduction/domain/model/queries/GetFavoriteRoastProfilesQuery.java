package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;

public record GetFavoriteRoastProfilesQuery(UserId userId) {
    public GetFavoriteRoastProfilesQuery {
        if (userId == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
    }
} 