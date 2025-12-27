package com.td1.td1.middleservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO pour la requête de création d'un serveur
 */
@Schema(description = "Requête pour créer un nouveau serveur")
public class CreateServerRequestDTO {
    
    @NotBlank(message = "Le nom du serveur est obligatoire")
    @Schema(description = "Nom du serveur à créer", example = "Serveur Production", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nom;

    public CreateServerRequestDTO() {
    }

    public CreateServerRequestDTO(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

