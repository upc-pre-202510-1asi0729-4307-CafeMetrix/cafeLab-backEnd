package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;

public record GetLotByIdQuery(LotId lotId) {
    public GetLotByIdQuery {
        if (lotId == null) {
            throw new IllegalArgumentException("LotId cannot be null");
        }
    }
} 