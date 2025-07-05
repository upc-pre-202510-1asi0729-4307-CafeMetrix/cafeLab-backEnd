package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transform;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.resources.CreateSupplierResource;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.resources.SupplierResource;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierTransform {
    
    public static SupplierResource toResource(Supplier supplier) {
        return new SupplierResource(
                supplier.getId().value().toString(),
                supplier.getUserId().value().toString(),
                supplier.getName(),
                supplier.getEmail().value(),
                supplier.getPhone().value(),
                supplier.getLocation().value(),
                supplier.getSpecialty().values()
        );
    }
    
    public static List<SupplierResource> toResourceList(List<Supplier> suppliers) {
        return suppliers.stream()
                .map(SupplierTransform::toResource)
                .collect(Collectors.toList());
    }
    
    public static CreateSupplierResource toCreateResource(Supplier supplier) {
        return new CreateSupplierResource(
                supplier.getUserId().value().toString(),
                supplier.getName(),
                supplier.getEmail().value(),
                supplier.getPhone().value(),
                supplier.getLocation().value(),
                supplier.getSpecialty().values()
        );
    }
} 