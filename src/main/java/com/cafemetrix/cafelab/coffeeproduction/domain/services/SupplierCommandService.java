package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateSupplierCommand;

public interface SupplierCommandService {
    Supplier createSupplier(CreateSupplierCommand command);
    Supplier updateSupplier(UpdateSupplierCommand command);
    boolean deleteSupplier(DeleteSupplierCommand command);
} 