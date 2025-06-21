package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record CreateSupplierResource(
    @Schema(description = "ID del usuario", example = "e7b8c8e2-8c8e-4e8e-8c8e-8e8e8e8e8e8e") String userId,
    @Schema(description = "Nombre del proveedor", example = "Café Don Pepe") String name,
    @Schema(description = "Correo electrónico", example = "donpepe@email.com") String email,
    @Schema(description = "Teléfono", example = "+573001234567") String phone,
    @Schema(description = "Ubicación", example = "Antioquia, Colombia") String location,
    @Schema(description = "Especialidades", example = "[\"Arábica\", \"Orgánico\"]") List<String> specialties
) {
    public CreateSupplierResource {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        if (specialties == null || specialties.isEmpty()) {
            throw new IllegalArgumentException("Specialties cannot be null or empty");
        }
    }
} 