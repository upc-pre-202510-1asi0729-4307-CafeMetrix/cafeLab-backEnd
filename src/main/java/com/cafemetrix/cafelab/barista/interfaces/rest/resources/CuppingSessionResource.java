package com.cafemetrix.cafelab.barista.interfaces.rest.resources;

/**
 * Resource representing a cupping session.
 */
public record CuppingSessionResource(Long id, String name, String description, Long userId) {
}