package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto;

import java.util.List;

public record CreateLotRequest(
    Long supplierId,
    String lotName,
    String coffeeType,
    String processingMethod,
    String altitude,
    String weight,
    List<String> certifications,
    String origin
) {} 