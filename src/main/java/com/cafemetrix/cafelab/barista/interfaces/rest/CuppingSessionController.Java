package com.cafemetrix.cafelab.barista.interfaces.rest;

import com.cafemetrix.cafelab.barista.domain.model.commands.*;
import com.cafemetrix.cafelab.barista.domain.model.queries.*;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionCommandService;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionQueryService;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.*;
import com.cafemetrix.cafelab.barista.interfaces.rest.transform.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/cupping-sessions", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Cupping Sessions", description = "Manage cupping sessions")
public class CuppingSessionController {

    private final CuppingSessionCommandService commandService;
    private final CuppingSessionQueryService queryService;

    public CuppingSessionController(
            CuppingSessionCommandService commandService,
            CuppingSessionQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    @Operation(summary = "Create a new cupping session")
    public ResponseEntity<CuppingSessionResource> create(@RequestBody CreateCuppingSessionResource resource) {
        var command = CreateCuppingSessionCommandFromResourceAssembler.toCommandFromResource(resource);
        var sessionId = commandService.handle(command);
        var sessionOpt = queryService.handle(new GetCuppingSessionByIdQuery(sessionId));
        return sessionOpt
                .map(session -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(CuppingSessionResourceFromEntityAssembler.toResourceFromEntity(session)))
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping
    @Operation(summary = "Get all cupping sessions for a user")
    public ResponseEntity<List<CuppingSessionResource>> getAll(@RequestParam Long userId) {
        var query = new GetAllCuppingSessionsQuery(userId);
        var sessions = queryService.handle(query);
        var resources = sessions.stream()
                .map(CuppingSessionResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cupping session by ID")
    public ResponseEntity<CuppingSessionResource> getById(@PathVariable Long id) {
        var query = new GetCuppingSessionByIdQuery(id);
        var session = queryService.handle(query);
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
        var updated = commandService.handle(command);
        return updated.map(value -> ResponseEntity.ok(
                        CuppingSessionResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a cupping session")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var command = new DeleteCuppingSessionCommand(id);
        commandService.handle(command);
        return ResponseEntity.ok(new MessageResource("Cupping session deleted successfully"));
    }
}