package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.DeleteLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.SupplierId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.LotCommandService;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.LotQueryService;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.*;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.CreateLotRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.LotDto;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.UpdateLotRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transformers.LotTransformer;
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
@RequestMapping("/api/lots")
@Tag(name = "Coffee Lots", description = "Coffee lot management operations")
public class LotController {

    @Autowired
    private LotCommandService lotCommandService;

    @Autowired
    private LotQueryService lotQueryService;

    @PostMapping
    @Operation(summary = "Create a new coffee lot", description = "Creates a new coffee lot for the authenticated user")
    public ResponseEntity<LotDto> createLot(
            @RequestBody CreateLotRequest request,
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        CreateLotCommand command = LotTransformer.toCreateCommand(request, userId);
        Lot lot = lotCommandService.createLot(command);
        LotDto dto = LotTransformer.toDto(lot);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    @Operation(summary = "Get all coffee lots", description = "Retrieves all coffee lots for the authenticated user")
    public ResponseEntity<List<LotDto>> getAllLots(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        GetAllLotsQuery query = new GetAllLotsQuery(new UserId(userId));
        List<Lot> lots = lotQueryService.getAllLots(query);
        List<LotDto> dtos = lots.stream()
                .map(LotTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get coffee lot by ID", description = "Retrieves a specific coffee lot by its ID")
    public ResponseEntity<LotDto> getLotById(
            @Parameter(description = "Lot ID") @PathVariable Long id) {
        
        GetLotByIdQuery query = new GetLotByIdQuery(new LotId(id));
        Optional<Lot> lot = lotQueryService.getLotById(query);
        
        return lot.map(l -> ResponseEntity.ok(LotTransformer.toDto(l)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    @Operation(summary = "Search coffee lot by name", description = "Searches for a coffee lot by its name")
    public ResponseEntity<LotDto> getLotByName(
            @Parameter(description = "Lot name") @RequestParam String lotName) {
        
        GetLotByNameQuery query = new GetLotByNameQuery(lotName);
        Optional<Lot> lot = lotQueryService.getLotByName(query);
        
        return lot.map(l -> ResponseEntity.ok(LotTransformer.toDto(l)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-supplier/{supplierId}")
    @Operation(summary = "Get coffee lots by supplier", description = "Retrieves all coffee lots for a specific supplier")
    public ResponseEntity<List<LotDto>> getLotsBySupplier(
            @Parameter(description = "Supplier ID") @PathVariable Long supplierId) {
        
        GetLotsBySupplierQuery query = new GetLotsBySupplierQuery(new SupplierId(supplierId));
        List<Lot> lots = lotQueryService.getLotsBySupplier(query);
        List<LotDto> dtos = lots.stream()
                .map(LotTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update coffee lot", description = "Updates an existing coffee lot")
    public ResponseEntity<LotDto> updateLot(
            @Parameter(description = "Lot ID") @PathVariable Long id,
            @RequestBody UpdateLotRequest request) {
        
        UpdateLotCommand command = LotTransformer.toUpdateCommand(request, id);
        Lot lot = lotCommandService.updateLot(command);
        LotDto dto = LotTransformer.toDto(lot);
        
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete coffee lot", description = "Deletes a coffee lot")
    public ResponseEntity<Void> deleteLot(
            @Parameter(description = "Lot ID") @PathVariable Long id) {
        
        DeleteLotCommand command = new DeleteLotCommand(new LotId(id));
        boolean deleted = lotCommandService.deleteLot(command);
        
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
} 