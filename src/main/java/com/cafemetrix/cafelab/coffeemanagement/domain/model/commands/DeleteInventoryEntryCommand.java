package com.cafemetrix.cafelab.coffeemanagement.domain.model.commands;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.InventoryEntryId;

public record DeleteInventoryEntryCommand(
    InventoryEntryId id
) {} 