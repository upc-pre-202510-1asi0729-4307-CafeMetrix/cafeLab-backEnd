package com.cafemetrix.cafelab.barista.interfaces.rest;

import com.cafemetrix.cafelab.barista.domain.model.commands.*;
import com.cafemetrix.cafelab.barista.domain.model.queries.*;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionCommandService;
import com.cafemetrix.cafelab.barista.domain.services.CuppingSessionQueryService;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.*;
import com.cafemetrix.cafelab.barista.interfaces.rest.transform.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.cafemetrix.cafelab.shared.interfaces.rest.resources.MessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Cupping Sessions Controller
 */

@RestController
@RequestMapping(value = "/api/v1/cupping-sessions", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Cupping Sessions", description = "Available cupping sessions endpoints")
public class CuppingSessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuppingSessionController.class);

    private final CuppingSessionCommandService cuppingSessionCommandService;
    private final CuppingSessionQueryService cuppingSessionQueryService;
    private final UserRepository userRepository;


    public CuppingSessionController(CuppingSessionCommandService cuppingSessionCommandService, CuppingSessionQueryService cuppingSessionQueryService, UserRepository userRepository) {
        this.cuppingSessionCommandService = cuppingSessionCommandService;
        this.cuppingSessionQueryService = cuppingSessionQueryService;
        this.userRepository = userRepository;

    }


    @PostMapping
    @Operation(summary = "Create a new cupping session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cupping Session Created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<CuppingSessionResource> createCuppingSession(
            @RequestBody CreateCuppingSessionResource resource,
            Authentication authentication,
            HttpServletRequest request) {

        LOGGER.info("=== POST /cupping-sessions called ===");
        LOGGER.info("Authorization header: {}", request.getHeader("Authorization"));
        LOGGER.info("Authentication object: {}", authentication != null ? authentication.getName() : "NULL");
        LOGGER.info("Request content type: {}", request.getContentType());
        
        if (authentication == null) {
            LOGGER.error("Authentication is null - returning 401");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = authentication.getName();
        LOGGER.info("Username from authentication: {}", username);
        
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username));

        LOGGER.info("User found: {}", user.getId());

        var userId = new UserId(user.getId());
        var createCuppingSessionCommand = CreateCuppingSessionCommandFromResourceAssembler
                .toCommandFromResource(resource, userId);

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
    public ResponseEntity<List<CuppingSessionResource>> getAll(
            Authentication authentication,
            HttpServletRequest request) {
        LOGGER.info("=== GET /cupping-sessions called ===");
        LOGGER.info("Authorization header: {}", request.getHeader("Authorization"));
        LOGGER.info("Authentication object: {}", authentication != null ? authentication.getName() : "NULL");
        
        String username = authentication.getName();
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Obtener el userId y usarlo en el query
        var query = new GetAllCuppingSessionsQuery(new UserId(user.getId()));
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