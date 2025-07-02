package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

import java.util.List;

public record LotDto(
    Long id,
    String lotName,
    String coffeeType,
    String processingMethod,
    String altitude,
    String weight,
    List<String> certifications,
    String origin,
    Long supplierId,
    Long userId,
    String status
) {} 