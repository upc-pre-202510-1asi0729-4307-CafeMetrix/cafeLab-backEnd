package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

/**
 * Resource for creating a cupping session.
 */
public record CreateCuppingSessionResource(String name, String description, Long userId) {
    public CreateCuppingSessionResource {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name is required");
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description is required");
        if (userId == null || userId <= 0)
            throw new IllegalArgumentException("User ID is required and must be greater than zero");
    }
}