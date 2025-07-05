package com.cafemetrix.cafelab.coffeeproduction.application.internal.commandservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.SupplierCommandService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.SupplierEntity;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierCommandServiceImpl implements SupplierCommandService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(CreateSupplierCommand command) {
        SupplierEntity entity = new SupplierEntity();
        entity.setUserId(command.userId().value());
        entity.setName(command.name());
        entity.setEmail(command.email());
        entity.setPhone(command.phone());
        entity.setLocation(command.location());
        entity.setSpecialties(String.join(",", command.specialties()));
        
        SupplierEntity saved = supplierRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Supplier updateSupplier(UpdateSupplierCommand command) {
        SupplierEntity entity = supplierRepository.findById(command.supplierId().value())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        
        entity.setName(command.name());
        entity.setEmail(command.email());
        entity.setPhone(command.phone());
        entity.setLocation(command.location());
        entity.setSpecialties(String.join(",", command.specialties()));
        
        SupplierEntity saved = supplierRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public boolean deleteSupplier(DeleteSupplierCommand command) {
        if (supplierRepository.existsById(command.supplierId().value())) {
            supplierRepository.deleteById(command.supplierId().value());
            return true;
        }
        return false;
    }

    private Supplier toDomain(SupplierEntity entity) {
        return new Supplier(
                new SupplierId(entity.getId()),
                new UserId(entity.getUserId()),
                entity.getName(),
                new EmailAddress(entity.getEmail()),
                new PhoneNumber(entity.getPhone()),
                new Location(entity.getLocation()),
                new Specialty(java.util.Arrays.asList(entity.getSpecialties().split(",")))
        );
    }
} 