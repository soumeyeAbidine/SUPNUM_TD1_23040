package com.td1.td1.middleservice.controller;

import com.td1.td1.middleservice.dto.*;
import com.td1.td1.middleservice.service.MiddleService;
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
 * Controller REST du middle-service
 * Expose les endpoints REST équivalents aux opérations SOAP
 */
@RestController
@RequestMapping("/api/servers")
@Tag(name = "Middle-Service REST", description = "API REST pour la gestion des serveurs (transforme SOAP en REST)")
public class MiddleServiceController {

    private final MiddleService middleService;

    public MiddleServiceController(MiddleService middleService) {
        this.middleService = middleService;
    }

    @PostMapping
    @Operation(
        summary = "Créer un nouveau serveur",
        description = "Crée un nouveau serveur avec le nom spécifié"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Serveur créé avec succès",
            content = @Content(schema = @Schema(implementation = ServerDTO.class))),
        @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    public ResponseEntity<ServerDTO> createServer(
            @Valid @RequestBody CreateServerRequestDTO request) {
        ServerDTO server = middleService.createServer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(server);
    }

    @GetMapping
    @Operation(
        summary = "Lister tous les serveurs",
        description = "Récupère la liste de tous les serveurs"
    )
    @ApiResponse(responseCode = "200", description = "Liste des serveurs récupérée avec succès")
    public ResponseEntity<List<ServerDTO>> getAllServers() {
        List<ServerDTO> servers = middleService.getAllServers();
        return ResponseEntity.ok(servers);
    }

    @PostMapping("/{id}/start")
    @Operation(
        summary = "Démarrer un serveur",
        description = "Démarre le serveur avec l'ID spécifié"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> startServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id) {
        ActionResponseDTO response = middleService.startServer(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/stop")
    @Operation(
        summary = "Arrêter un serveur",
        description = "Arrête le serveur avec l'ID spécifié"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> stopServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id) {
        ActionResponseDTO response = middleService.stopServer(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/rename")
    @Operation(
        summary = "Renommer un serveur",
        description = "Renomme le serveur avec l'ID spécifié"
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
        ActionResponseDTO response = middleService.renameServer(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Supprimer un serveur",
        description = "Supprime le serveur avec l'ID spécifié"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Opération effectuée",
            content = @Content(schema = @Schema(implementation = ActionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Serveur non trouvé")
    })
    public ResponseEntity<ActionResponseDTO> deleteServer(
            @Parameter(description = "ID du serveur", required = true)
            @PathVariable Long id) {
        ActionResponseDTO response = middleService.deleteServer(id);
        return ResponseEntity.ok(response);
    }
}

