package com.cafemetrix.cafelab.coffeemanagement.domain.model.queries;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.UserId;

public record GetAllProductionCostsQuery(
    UserId userId
) {} 