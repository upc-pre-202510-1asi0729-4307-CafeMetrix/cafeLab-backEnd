package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transform;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.resources.UpdateSupplierResource;

/**
 * Assembler for transforming UpdateSupplierResource to UpdateSupplierCommand
 */
public class UpdateSupplierCommandFromResourceAssembler {
    public static UpdateSupplierCommand toCommandFromResource(Long supplierId, UpdateSupplierResource resource) {
        return new UpdateSupplierCommand(
            supplierId,
            resource.name(),
            resource.email(),
            resource.phone(),
            resource.location(),
            resource.specialties()
        );
    }
} 