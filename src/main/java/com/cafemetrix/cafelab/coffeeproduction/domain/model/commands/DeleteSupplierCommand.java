package com.cafemetrix.cafelab.coffeeproduction.domain.model.commands;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.SupplierId;

public record DeleteSupplierCommand(SupplierId supplierId) {
    public DeleteSupplierCommand {
        if (supplierId == null) {
            throw new IllegalArgumentException("SupplierId cannot be null");
        }
    }
} 