package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

import java.time.LocalDateTime;

public record InventoryEntryDto(
    Long id,
    Long coffeeLotId,
    Long userId,
    Double quantityUsed,
    LocalDateTime dateUsed,
    String finalProduct
) {} 