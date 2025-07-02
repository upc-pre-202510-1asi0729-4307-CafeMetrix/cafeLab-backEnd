package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.ProductionCost;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.ProductionCostCommandService;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.ProductionCostQueryService;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto.*;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.transformers.ProductionCostTransformer;
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
@RequestMapping("/api/production-costs")
@Tag(name = "Production Costs", description = "Coffee production cost management operations")
public class ProductionCostController {

    @Autowired
    private ProductionCostCommandService productionCostCommandService;

    @Autowired
    private ProductionCostQueryService productionCostQueryService;

    @PostMapping
    @Operation(summary = "Create a new production cost", description = "Creates a new production cost calculation")
    public ResponseEntity<ProductionCostDto> createProductionCost(
            @RequestBody CreateProductionCostRequest request,
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        CreateProductionCostCommand command = ProductionCostTransformer.toCreateCommand(request, userId);
        ProductionCost productionCost = productionCostCommandService.createProductionCost(command);
        ProductionCostDto dto = ProductionCostTransformer.toDto(productionCost);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    @Operation(summary = "Get all production costs", description = "Retrieves all production costs for the authenticated user")
    public ResponseEntity<List<ProductionCostDto>> getAllProductionCosts(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        GetAllProductionCostsQuery query = new GetAllProductionCostsQuery(new UserId(userId));
        List<ProductionCost> productionCosts = productionCostQueryService.getAllProductionCosts(query);
        List<ProductionCostDto> dtos = productionCosts.stream()
                .map(ProductionCostTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get production cost by ID", description = "Retrieves a specific production cost by its ID")
    public ResponseEntity<ProductionCostDto> getProductionCostById(
            @Parameter(description = "Production Cost ID") @PathVariable Long id) {
        
        GetProductionCostByIdQuery query = new GetProductionCostByIdQuery(new ProductionCostId(id));
        Optional<ProductionCost> productionCost = productionCostQueryService.getProductionCostById(query);
        
        return productionCost.map(cost -> ResponseEntity.ok(ProductionCostTransformer.toDto(cost)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-lot/{lotId}")
    @Operation(summary = "Get production costs by lot", description = "Retrieves all production costs for a specific coffee lot")
    public ResponseEntity<List<ProductionCostDto>> getProductionCostsByLot(
            @Parameter(description = "Lot ID") @PathVariable Long lotId) {
        
        GetProductionCostsByLotQuery query = new GetProductionCostsByLotQuery(new LotId(lotId));
        List<ProductionCost> productionCosts = productionCostQueryService.getProductionCostsByLot(query);
        List<ProductionCostDto> dtos = productionCosts.stream()
                .map(ProductionCostTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update production cost", description = "Updates an existing production cost")
    public ResponseEntity<ProductionCostDto> updateProductionCost(
            @Parameter(description = "Production Cost ID") @PathVariable Long id,
            @RequestBody UpdateProductionCostRequest request) {
        
        UpdateProductionCostCommand command = ProductionCostTransformer.toUpdateCommand(request, id);
        ProductionCost productionCost = productionCostCommandService.updateProductionCost(command);
        ProductionCostDto dto = ProductionCostTransformer.toDto(productionCost);
        
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete production cost", description = "Deletes a production cost")
    public ResponseEntity<Void> deleteProductionCost(
            @Parameter(description = "Production Cost ID") @PathVariable Long id) {
        
        DeleteProductionCostCommand command = new DeleteProductionCostCommand(new ProductionCostId(id));
        boolean deleted = productionCostCommandService.deleteProductionCost(command);
        
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
} 