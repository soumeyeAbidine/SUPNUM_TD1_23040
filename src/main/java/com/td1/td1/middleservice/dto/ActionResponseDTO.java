package com.td1.td1.middleservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO pour les réponses d'actions (start, stop, rename, delete)
 */
@Schema(description = "Réponse indiquant le succès d'une action")
public class ActionResponseDTO {
    
    @Schema(description = "Indique si l'action a réussi", example = "true")
    private boolean success;
    
    @Schema(description = "Message optionnel", example = "Serveur démarré avec succès")
    private String message;

    public ActionResponseDTO() {
    }

    public ActionResponseDTO(boolean success) {
        this.success = success;
    }

    public ActionResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

