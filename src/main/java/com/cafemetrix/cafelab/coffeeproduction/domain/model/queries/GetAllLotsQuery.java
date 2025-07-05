package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;

public record GetAllLotsQuery(UserId userId) {
    public GetAllLotsQuery {
        if (userId == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
    }
} 