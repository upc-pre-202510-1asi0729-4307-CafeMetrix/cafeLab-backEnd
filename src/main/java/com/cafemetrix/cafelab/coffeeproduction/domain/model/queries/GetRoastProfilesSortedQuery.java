package com.cafemetrix.cafelab.coffeeproduction.domain.model.queries;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;

public record GetRoastProfilesSortedQuery(UserId userId, String sortOrder) {
    public GetRoastProfilesSortedQuery {
        if (userId == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
        if (sortOrder == null || sortOrder.trim().isEmpty()) {
            throw new IllegalArgumentException("Sort order cannot be null or empty");
        }
        if (!sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc")) {
            throw new IllegalArgumentException("Sort order must be 'asc' or 'desc'");
        }
    }
} 