package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;

import java.util.List;

public record CreateSupplierCommand(
    UserId userId,
    String name,
    String email,
    String phone,
    String location,
    List<String> specialties
) {
    public CreateSupplierCommand {
        if (userId == null) {
            throw new IllegalArgumentException("UserId cannot be null");
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