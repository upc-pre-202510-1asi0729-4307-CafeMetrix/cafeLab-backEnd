package com.cafemetrix.cafelab.coffeemanagement.domain.model.queries;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.LotId;

public record GetInventoryEntriesByLotQuery(
    LotId lotId
) {} 