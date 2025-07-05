package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto;

public record UpdateRoastProfileRequest(
    String name,
    String type,
    int duration,
    double tempInitial,
    double tempFinal,
    boolean isFavorite,
    Long lot,
    double tempStart,
    double tempEnd
) {} 