package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;

public record GetRoastProfilesByLotQuery(LotId lotId) {
    public GetRoastProfilesByLotQuery {
        if (lotId == null) {
            throw new IllegalArgumentException("LotId cannot be null");
        }
    }
} 