package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

import java.time.LocalDateTime;

public record UpdateInventoryEntryRequest(
    Double quantityUsed,
    LocalDateTime dateUsed,
    String finalProduct
) {} 