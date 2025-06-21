package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

public record GetRoastProfileByNameQuery(String name) {
    public GetRoastProfileByNameQuery {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
} 