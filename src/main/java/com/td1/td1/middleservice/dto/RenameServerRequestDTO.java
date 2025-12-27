package com.td1.td1.middleservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO pour la requête de renommage d'un serveur
 */
@Schema(description = "Requête pour renommer un serveur")
public class RenameServerRequestDTO {
    
    @NotBlank(message = "Le nouveau nom du serveur est obligatoire")
    @Schema(description = "Nouveau nom du serveur", example = "Serveur Production Renommé", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nom;

    public RenameServerRequestDTO() {
    }

    public RenameServerRequestDTO(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

