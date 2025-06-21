package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.RoastProfileId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.RoastProfileCommandService;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.RoastProfileQueryService;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.*;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.CreateRoastProfileRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.RoastProfileDto;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.UpdateRoastProfileRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transformers.RoastProfileTransformer;
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
@RequestMapping("/api/roast-profiles")
@Tag(name = "Roast Profiles", description = "Roast profile management operations")
public class RoastProfileController {

    @Autowired
    private RoastProfileCommandService roastProfileCommandService;

    @Autowired
    private RoastProfileQueryService roastProfileQueryService;

    @PostMapping
    @Operation(summary = "Create a new roast profile", description = "Creates a new roast profile for the authenticated user")
    public ResponseEntity<RoastProfileDto> createRoastProfile(
            @RequestBody CreateRoastProfileRequest request,
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        CreateRoastProfileCommand command = RoastProfileTransformer.toCreateCommand(request, userId);
        RoastProfile roastProfile = roastProfileCommandService.createRoastProfile(command);
        RoastProfileDto dto = RoastProfileTransformer.toDto(roastProfile);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    @Operation(summary = "Get all roast profiles", description = "Retrieves all roast profiles for the authenticated user")
    public ResponseEntity<List<RoastProfileDto>> getAllRoastProfiles(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        GetAllRoastProfilesQuery query = new GetAllRoastProfilesQuery(new UserId(userId));
        List<RoastProfile> roastProfiles = roastProfileQueryService.getAllRoastProfiles(query);
        List<RoastProfileDto> dtos = roastProfiles.stream()
                .map(RoastProfileTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/sorted")
    @Operation(summary = "Get roast profiles sorted by creation date", description = "Retrieves roast profiles sorted by creation date (asc/desc)")
    public ResponseEntity<List<RoastProfileDto>> getRoastProfilesSorted(
            @Parameter(description = "User ID") @RequestParam Long userId,
            @Parameter(description = "Sort order (asc/desc)") @RequestParam(defaultValue = "desc") String sortOrder) {
        
        GetRoastProfilesSortedQuery query = new GetRoastProfilesSortedQuery(new UserId(userId), sortOrder);
        List<RoastProfile> roastProfiles = roastProfileQueryService.getRoastProfilesSorted(query);
        List<RoastProfileDto> dtos = roastProfiles.stream()
                .map(RoastProfileTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get roast profile by ID", description = "Retrieves a specific roast profile by its ID")
    public ResponseEntity<RoastProfileDto> getRoastProfileById(
            @Parameter(description = "Roast profile ID") @PathVariable Long id) {
        
        GetRoastProfileByIdQuery query = new GetRoastProfileByIdQuery(new RoastProfileId(id));
        Optional<RoastProfile> roastProfile = roastProfileQueryService.getRoastProfileById(query);
        
        return roastProfile.map(profile -> ResponseEntity.ok(RoastProfileTransformer.toDto(profile)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    @Operation(summary = "Search roast profile by name", description = "Searches for a roast profile by its name")
    public ResponseEntity<RoastProfileDto> getRoastProfileByName(
            @Parameter(description = "Roast profile name") @RequestParam String name) {
        
        GetRoastProfileByNameQuery query = new GetRoastProfileByNameQuery(name);
        Optional<RoastProfile> roastProfile = roastProfileQueryService.getRoastProfileByName(query);
        
        return roastProfile.map(profile -> ResponseEntity.ok(RoastProfileTransformer.toDto(profile)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-lot/{lotId}")
    @Operation(summary = "Get roast profiles by lot", description = "Retrieves all roast profiles for a specific lot")
    public ResponseEntity<List<RoastProfileDto>> getRoastProfilesByLot(
            @Parameter(description = "Lot ID") @PathVariable Long lotId) {
        
        GetRoastProfilesByLotQuery query = new GetRoastProfilesByLotQuery(new LotId(lotId));
        List<RoastProfile> roastProfiles = roastProfileQueryService.getRoastProfilesByLot(query);
        List<RoastProfileDto> dtos = roastProfiles.stream()
                .map(RoastProfileTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/favorites")
    @Operation(summary = "Get favorite roast profiles", description = "Retrieves all favorite roast profiles for the authenticated user")
    public ResponseEntity<List<RoastProfileDto>> getFavoriteRoastProfiles(
            @Parameter(description = "User ID") @RequestParam Long userId) {
        
        GetFavoriteRoastProfilesQuery query = new GetFavoriteRoastProfilesQuery(new UserId(userId));
        List<RoastProfile> roastProfiles = roastProfileQueryService.getFavoriteRoastProfiles(query);
        List<RoastProfileDto> dtos = roastProfiles.stream()
                .map(RoastProfileTransformer::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update roast profile", description = "Updates an existing roast profile")
    public ResponseEntity<RoastProfileDto> updateRoastProfile(
            @Parameter(description = "Roast profile ID") @PathVariable Long id,
            @RequestBody UpdateRoastProfileRequest request) {
        
        UpdateRoastProfileCommand command = RoastProfileTransformer.toUpdateCommand(request, id);
        RoastProfile roastProfile = roastProfileCommandService.updateRoastProfile(command);
        RoastProfileDto dto = RoastProfileTransformer.toDto(roastProfile);
        
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}/toggle-favorite")
    @Operation(summary = "Toggle favorite status", description = "Toggles the favorite status of a roast profile")
    public ResponseEntity<RoastProfileDto> toggleFavorite(
            @Parameter(description = "Roast profile ID") @PathVariable Long id) {
        
        ToggleFavoriteCommand command = new ToggleFavoriteCommand(new RoastProfileId(id));
        RoastProfile roastProfile = roastProfileCommandService.toggleFavorite(command);
        RoastProfileDto dto = RoastProfileTransformer.toDto(roastProfile);
        
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}/duplicate")
    @Operation(summary = "Duplicate roast profile", description = "Creates a copy of an existing roast profile")
    public ResponseEntity<RoastProfileDto> duplicateRoastProfile(
            @Parameter(description = "Roast profile ID") @PathVariable Long id) {
        
        DuplicateRoastProfileCommand command = new DuplicateRoastProfileCommand(new RoastProfileId(id));
        RoastProfile roastProfile = roastProfileCommandService.duplicateRoastProfile(command);
        RoastProfileDto dto = RoastProfileTransformer.toDto(roastProfile);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete roast profile", description = "Deletes a roast profile")
    public ResponseEntity<Void> deleteRoastProfile(
            @Parameter(description = "Roast profile ID") @PathVariable Long id) {
        
        DeleteRoastProfileCommand command = new DeleteRoastProfileCommand(new RoastProfileId(id));
        boolean deleted = roastProfileCommandService.deleteRoastProfile(command);
        
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
} 