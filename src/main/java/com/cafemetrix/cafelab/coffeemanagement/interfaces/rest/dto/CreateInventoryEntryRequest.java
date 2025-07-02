package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

import java.time.LocalDateTime;

public record CreateInventoryEntryRequest(
    Long coffeeLotId,
    Double quantityUsed,
    LocalDateTime dateUsed,
    String finalProduct
) {} 