package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

public record GetLotByNameQuery(String lotName) {
    public GetLotByNameQuery {
        if (lotName == null || lotName.trim().isEmpty()) {
            throw new IllegalArgumentException("Lot name cannot be null or empty");
        }
    }
} 