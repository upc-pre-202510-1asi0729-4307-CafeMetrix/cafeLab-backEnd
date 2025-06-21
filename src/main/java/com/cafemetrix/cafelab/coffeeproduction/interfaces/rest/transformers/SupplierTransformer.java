package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transformers;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.SupplierId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.CreateSupplierRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.SupplierDto;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.UpdateSupplierRequest;

public class SupplierTransformer {

    public static SupplierDto toDto(Supplier supplier) {
        return new SupplierDto(
                supplier.getId().value(),
                supplier.getUserId().value(),
                supplier.getName(),
                supplier.getEmail().value(),
                supplier.getPhone().value(),
                supplier.getLocation().value(),
                String.join(",", supplier.getSpecialty().values())
        );
    }

    public static CreateSupplierCommand toCreateCommand(CreateSupplierRequest request, Long userId) {
        return new CreateSupplierCommand(
                new UserId(userId),
                request.name(),
                request.email(),
                request.phone(),
                request.location(),
                request.specialties()
        );
    }

    public static UpdateSupplierCommand toUpdateCommand(UpdateSupplierRequest request, Long supplierId) {
        return new UpdateSupplierCommand(
                new SupplierId(supplierId),
                request.name(),
                request.email(),
                request.phone(),
                request.location(),
                request.specialties()
        );
    }
} 