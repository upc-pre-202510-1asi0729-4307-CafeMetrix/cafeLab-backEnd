package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto;

public record SupplierDto(
    Long id,
    Long userId,
    String name,
    String email,
    String phone,
    String location,
    String specialties
) {} 