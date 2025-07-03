package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

/**
 * Resource for updating a cupping session.
 */
public record UpdateCuppingSessionResource(String name, String description) {
    public UpdateCuppingSessionResource {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name is required");
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description is required");
    }
}