package com.cafemetrix.cafelab.coffeemanagement.domain.model.queries;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.InventoryEntryId;

public record GetInventoryEntryByIdQuery(
    InventoryEntryId id
) {} 