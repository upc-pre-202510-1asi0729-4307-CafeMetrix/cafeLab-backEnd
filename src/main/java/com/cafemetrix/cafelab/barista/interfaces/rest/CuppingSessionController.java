package com.cafemetrix.cafelab.barista.interfaces.rest;

import com.cafemetrix.cafelab.barista.domain.model.commands.*;
import com.cafemetrix.cafelab.barista.domain.model.queries.*;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionCommandService;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionQueryService;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.*;
import com.cafemetrix.cafelab.barista.interfaces.rest.transform.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.shared.interfaces.rest.resources.MessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Cupping Sessions Controller
 */

@RestController
@RequestMapping(value = "/api/v1/cupping-sessions", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Cupping Sessions", description = "Available cupping sessions endpoints")
public class CuppingSessionController {

    private final CuppingSessionCommandService cuppingSessionCommandService;
    private final CuppingSessionQueryService cuppingSessionQueryService;

    public CuppingSessionController(CuppingSessionCommandService cuppingSessionCommandService, CuppingSessionQueryService cuppingSessionQueryService) {
        this.cuppingSessionCommandService = cuppingSessionCommandService;
        this.cuppingSessionQueryService = cuppingSessionQueryService;
    }


    @PostMapping
    @Operation(summary = "Create a new cupping session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cupping Session Created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<CuppingSessionResource> createCuppingSession(@RequestBody CreateCuppingSessionResource resource) {
        var createCuppingSessionCommand = CreateCuppingSessionCommandFromResourceAssembler.toCommandFromResource(resource);
        var sessionId = cuppingSessionCommandService.handle(createCuppingSessionCommand);
        var createdSessionOpt = cuppingSessionQueryService.handle(new GetCuppingSessionByIdQuery(sessionId));

        return createdSessionOpt
                .map(session -> new ResponseEntity<>(
                        CuppingSessionResourceFromEntityAssembler.toResourceFromEntity(session),
                        HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping
    @Operation(summary = "Get all cupping sessions for a user")
    public ResponseEntity<List<CuppingSessionResource>> getAll(@RequestParam Long userId) {
        var query = new GetAllCuppingSessionsQuery(new UserId(userId));
        var sessions = cuppingSessionQueryService.handle(query);
        var resources = sessions.stream()
                .map(CuppingSessionResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cupping session by ID")
    public ResponseEntity<CuppingSessionResource> getById(@PathVariable Long id) {
        var query = new GetCuppingSessionByIdQuery(id);
        var session = cuppingSessionQueryService.handle(query);
        return session.map(value -> ResponseEntity.ok(
                        CuppingSessionResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a cupping session")
    public ResponseEntity<CuppingSessionResource> update(
            @PathVariable Long id,
            @RequestBody UpdateCuppingSessionResource resource) {
        var command = UpdateCuppingSessionCommandFromResourceAssembler.toCommandFromResource(id, resource);
        var updated = cuppingSessionCommandService.handle(command);
        return updated.map(value -> ResponseEntity.ok(
                        CuppingSessionResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a cupping session")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var command = new DeleteCuppingSessionCommand(id);
        cuppingSessionCommandService.handle(command);
        return ResponseEntity.ok(new MessageResource("Cupping session deleted successfully"));
    }
}