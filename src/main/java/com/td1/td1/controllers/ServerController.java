package com.td1.td1.controllers;

import com.td1.td1.models.serveur;
import com.td1.td1.service.ServerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @PostMapping
    public ResponseEntity<serveur> createServer(@RequestParam String nom) {
        return ResponseEntity.ok(serverService.createServer(nom));
    }

    @GetMapping
    public ResponseEntity<List<serveur>> getAllServers() {
        return ResponseEntity.ok(serverService.getAllServers());
    }

    @PutMapping("/{id}/rename")
    public ResponseEntity<serveur> renameServer(@PathVariable Long id, @RequestParam String nom) {
        return serverService.renameServer(id, nom)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Boolean> getServerStatus(@PathVariable Long id) {
        return serverService.getServerStatus(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<serveur> startServer(@PathVariable Long id) {
        return serverService.startServer(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/stop")
    public ResponseEntity<serveur> stopServer(@PathVariable Long id) {
        return serverService.stopServer(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServer(@PathVariable Long id) {
        boolean deleted = serverService.deleteServer(id);
        if (deleted) return ResponseEntity.ok("Serveur supprimé avec succès.");
        return ResponseEntity.badRequest().body("Impossible de supprimer un serveur en cours d'exécution.");
    }
}
