package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest;

import com.cafemetrix.cafelab.coffeemanagement.application.internal.queryservices.CoffeeLotQueryService;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.InventoryEntry;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.InventoryEntryCommandService;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.InventoryEntryQueryService;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto.*;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.transformers.InventoryEntryTransformer;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.transformers.LotTransformer;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
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

@RestController
@RequestMapping("/api/inventory-entries")
@Tag(name = "Inventory Entries", description = "Coffee inventory management operations")
public class InventoryEntryController {

    @Autowired
    private InventoryEntryCommandService inventoryEntryCommandService;

    @Autowired
    private InventoryEntryQueryService inventoryEntryQueryService;

    @Autowired
    private CoffeeLotQueryService coffeeLotQueryService;

    @PostMapping
    @Operation(summary = "Create a new inventory entry", description = "Creates a new inventory entry for coffee consumption")
    public ResponseEntity<InventoryEntryDto> createInventoryEntry(
            @RequestBody CreateInventoryEntryRequest request,
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        CreateInventoryEntryCommand command = InventoryEntryTransformer.toCreateCommand(request, userId);
        InventoryEntry inventoryEntry = inventoryEntryCommandService.createInventoryEntry(command);
        InventoryEntryDto dto = InventoryEntryTransformer.toDto(inventoryEntry);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    @Operation(summary = "Get all inventory entries", description = "Retrieves all inventory entries for the authenticated user")
    public ResponseEntity<List<InventoryEntryDto>> getAllInventoryEntries(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        GetAllInventoryEntriesQuery query = new GetAllInventoryEntriesQuery(new UserId(userId));
        List<InventoryEntry> inventoryEntries = inventoryEntryQueryService.getAllInventoryEntries(query);
        List<InventoryEntryDto> dtos = inventoryEntries.stream()
                .map(InventoryEntryTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get inventory entry by ID", description = "Retrieves a specific inventory entry by its ID")
    public ResponseEntity<InventoryEntryDto> getInventoryEntryById(
            @Parameter(description = "Inventory Entry ID") @PathVariable Long id) {
        
        GetInventoryEntryByIdQuery query = new GetInventoryEntryByIdQuery(new InventoryEntryId(id));
        Optional<InventoryEntry> inventoryEntry = inventoryEntryQueryService.getInventoryEntryById(query);
        
        return inventoryEntry.map(entry -> ResponseEntity.ok(InventoryEntryTransformer.toDto(entry)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-lot/{lotId}")
    @Operation(summary = "Get inventory entries by lot", description = "Retrieves all inventory entries for a specific coffee lot")
    public ResponseEntity<List<InventoryEntryDto>> getInventoryEntriesByLot(
            @Parameter(description = "Lot ID") @PathVariable Long lotId) {
        
        GetInventoryEntriesByLotQuery query = new GetInventoryEntriesByLotQuery(new LotId(lotId));
        List<InventoryEntry> inventoryEntries = inventoryEntryQueryService.getInventoryEntriesByLot(query);
        List<InventoryEntryDto> dtos = inventoryEntries.stream()
                .map(InventoryEntryTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/available-lots")
    @Operation(summary = "Get available coffee lots", description = "Retrieves all available coffee lots for the authenticated user")
    public ResponseEntity<List<LotDto>> getAvailableLots(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        List<Lot> lots = coffeeLotQueryService.getLotsByUserId(userId);
        List<LotDto> dtos = lots.stream()
                .map(LotTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update inventory entry", description = "Updates an existing inventory entry")
    public ResponseEntity<InventoryEntryDto> updateInventoryEntry(
            @Parameter(description = "Inventory Entry ID") @PathVariable Long id,
            @RequestBody UpdateInventoryEntryRequest request) {
        
        UpdateInventoryEntryCommand command = InventoryEntryTransformer.toUpdateCommand(request, id);
        InventoryEntry inventoryEntry = inventoryEntryCommandService.updateInventoryEntry(command);
        InventoryEntryDto dto = InventoryEntryTransformer.toDto(inventoryEntry);
        
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete inventory entry", description = "Deletes an inventory entry")
    public ResponseEntity<Void> deleteInventoryEntry(
            @Parameter(description = "Inventory Entry ID") @PathVariable Long id) {
        
        DeleteInventoryEntryCommand command = new DeleteInventoryEntryCommand(new InventoryEntryId(id));
        boolean deleted = inventoryEntryCommandService.deleteInventoryEntry(command);
        
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
} 