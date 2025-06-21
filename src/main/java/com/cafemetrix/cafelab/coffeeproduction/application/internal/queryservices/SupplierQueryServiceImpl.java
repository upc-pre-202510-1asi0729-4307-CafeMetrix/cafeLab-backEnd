package com.cafemetrix.cafelab.coffeeproduction.application.internal.queryservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllSuppliersQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByNameQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.SupplierQueryService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.SupplierEntity;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierQueryServiceImpl implements SupplierQueryService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers(GetAllSuppliersQuery query) {
        return supplierRepository.findAllByUserId(query.userId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Supplier> getSupplierByName(GetSupplierByNameQuery query) {
        return supplierRepository.findByName(query.name())
                .map(this::toDomain);
    }

    @Override
    public Optional<Supplier> getSupplierById(GetSupplierByIdQuery query) {
        return supplierRepository.findById(query.supplierId().value())
                .map(this::toDomain);
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