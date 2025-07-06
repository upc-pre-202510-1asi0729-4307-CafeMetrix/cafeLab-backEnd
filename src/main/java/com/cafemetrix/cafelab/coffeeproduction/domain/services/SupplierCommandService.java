package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateSupplierCommand;

import java.util.Optional;

/**
 * Supplier Command Service Interface
 */
public interface SupplierCommandService {
    Optional<Supplier> handle(CreateSupplierCommand command);
    Optional<Supplier> handle(UpdateSupplierCommand command);
    boolean handle(DeleteSupplierCommand command);
} 