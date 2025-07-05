package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Supplier;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateSupplierCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllSuppliersQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetSupplierByNameQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.SupplierId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.SupplierCommandService;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.SupplierQueryService;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.CreateSupplierRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.SupplierDto;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.UpdateSupplierRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transformers.SupplierTransformer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Tag(name = "Suppliers", description = "API para gestión de proveedores de café")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    @Autowired
    private SupplierCommandService supplierCommandService;
    
    @Autowired
    private SupplierQueryService supplierQueryService;

    @Operation(summary = "Registrar un nuevo proveedor")
    @PostMapping
    public ResponseEntity<SupplierDto> registerSupplier(
            @RequestBody CreateSupplierRequest request,
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        CreateSupplierCommand command = SupplierTransformer.toCreateCommand(request, userId);
        Supplier supplier = supplierCommandService.createSupplier(command);
        SupplierDto dto = SupplierTransformer.toDto(supplier);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Operation(summary = "Editar información de un proveedor")
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto> editSupplier(
            @Parameter(description = "Supplier ID") @PathVariable Long id,
            @RequestBody UpdateSupplierRequest request) {
        
        UpdateSupplierCommand command = SupplierTransformer.toUpdateCommand(request, id);
        Supplier supplier = supplierCommandService.updateSupplier(command);
        SupplierDto dto = SupplierTransformer.toDto(supplier);
        
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Eliminar un proveedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(
            @Parameter(description = "Supplier ID") @PathVariable Long id) {
        
        DeleteSupplierCommand command = new DeleteSupplierCommand(new SupplierId(id));
        boolean deleted = supplierCommandService.deleteSupplier(command);
        
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtener información de un proveedor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(
            @Parameter(description = "Supplier ID") @PathVariable Long id) {
        
        GetSupplierByIdQuery query = new GetSupplierByIdQuery(new SupplierId(id));
        Optional<Supplier> supplier = supplierQueryService.getSupplierById(query);
        
        return supplier.map(s -> ResponseEntity.ok(SupplierTransformer.toDto(s)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar proveedor por nombre")
    @GetMapping("/search")
    public ResponseEntity<SupplierDto> getSupplierByName(
            @Parameter(description = "Supplier name") @RequestParam String name) {
        
        GetSupplierByNameQuery query = new GetSupplierByNameQuery(name);
        Optional<Supplier> supplier = supplierQueryService.getSupplierByName(query);
        
        return supplier.map(s -> ResponseEntity.ok(SupplierTransformer.toDto(s)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener todos los proveedores registrados por un usuario")
    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAllSuppliersByUserId(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        GetAllSuppliersQuery query = new GetAllSuppliersQuery(new UserId(userId));
        List<Supplier> suppliers = supplierQueryService.getAllSuppliers(query);
        List<SupplierDto> dtos = suppliers.stream()
                .map(SupplierTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }
} 