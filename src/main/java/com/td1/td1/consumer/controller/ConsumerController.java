package com.td1.td1.consumer.controller;

import com.td1.td1.consumer.service.ConsumerService;
import com.td1.td1.middleservice.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST du service consommateur
 * Consomme le middle-service REST (ne communique pas directement avec SOAP)
 */
@RestController
@RequestMapping("/consumer/servers")
@Tag(name = "Service Consommateur REST", description = "API REST consommateur qui utilise le middle-service")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @PostMapping
    @Operation(
        summary = "Créer un nouveau serveur",
        description = "Crée un nouveau serveur via le middle-service"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Serveur créé avec succès",
            content = @Content(schema = @Schema(implementation = ServerDTO.class))),
        @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    public ResponseEntity<ServerDTO> createServer(
            @Valid @RequestBody CreateServerRequestDTO request) {
        ServerDTO server = consumerService.createServer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(server);
    }

    @GetMapping
    @Operation(
        summary = "Lister tous les serveurs",
        description = "Récupère la liste de tous les serveurs via le middle-service"
    )
    @ApiResponse(responseCode = "200", description = "Liste des serveurs récupérée avec succès")
    public ResponseEntity<List<ServerDTO>> getAllServers() {
        List<ServerDTO> servers = consumerService.getAllServers();
        return ResponseEntity.ok(servers);
    }

    @PostMapping("/{id}/start")
    @Operation(
        summary = "Démarrer un serveur",
        description = "Démarre le serveur via le middle-service"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> startServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id) {
        ActionResponseDTO response = consumerService.startServer(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/stop")
    @Operation(
        summary = "Arrêter un serveur",
        description = "Arrête le serveur via le middle-service"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> stopServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id) {
        ActionResponseDTO response = consumerService.stopServer(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/rename")
    @Operation(
        summary = "Renommer un serveur",
        description = "Renomme le serveur via le middle-service"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Requête invalide"),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> renameServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id,
            @Valid @RequestBody RenameServerRequestDTO request) {
        ActionResponseDTO response = consumerService.renameServer(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Supprimer un serveur",
        description = "Supprime le serveur via le middle-service"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> deleteServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id) {
        ActionResponseDTO response = consumerService.deleteServer(id);
        return ResponseEntity.ok(response);
    }
}

