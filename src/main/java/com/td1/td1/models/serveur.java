package com.td1.td1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class serveur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private boolean statut; // true = démarré, false = arrêté

    // Constructeur sans paramètre
    public serveur() {}

    // Constructeur avec nom
    public serveur(String nom) {
        this.nom = nom;
        this.statut = false; // serveur arrêté par défaut
    }
}
