package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto;

import java.time.LocalDateTime;

public record RoastProfileDto(
    Long id,
    Long userId,
    String name,
    String type,
    int duration,
    double tempInitial,
    double tempFinal,
    boolean isFavorite,
    LocalDateTime createdAt,
    Long lot,
    double tempStart,
    double tempEnd
) {} 