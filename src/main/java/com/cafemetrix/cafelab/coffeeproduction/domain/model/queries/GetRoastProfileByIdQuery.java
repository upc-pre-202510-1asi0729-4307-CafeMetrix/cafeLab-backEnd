package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.RoastProfileId;

public record GetRoastProfileByIdQuery(RoastProfileId roastProfileId) {
    public GetRoastProfileByIdQuery {
        if (roastProfileId == null) {
            throw new IllegalArgumentException("RoastProfileId cannot be null");
        }
    }
} 