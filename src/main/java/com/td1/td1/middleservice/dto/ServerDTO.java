package com.td1.td1.middleservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO représentant un serveur pour les échanges REST
 */
@Schema(description = "Représentation d'un serveur")
public class ServerDTO {

    @Schema(description = "Identifiant unique du serveur", example = "1")
    private Long id;

    @Schema(description = "Nom du serveur", example = "Serveur Production")
    private String nom;

    @Schema(description = "Statut du serveur (true = démarré, false = arrêté)", example = "true")
    private boolean statut;

    public ServerDTO() {
    }

    public ServerDTO(Long id, String nom, boolean statut) {
        this.id = id;
        this.nom = nom;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}
