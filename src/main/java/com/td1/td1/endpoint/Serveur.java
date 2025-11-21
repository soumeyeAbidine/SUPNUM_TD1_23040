package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Serveur", propOrder = { "id", "nom", "statut" }, namespace = "http://td1.com/serveur")
public class Serveur {

    @XmlElement(namespace = "http://td1.com/serveur")
    private long id;
    
    @XmlElement(namespace = "http://td1.com/serveur")
    private String nom;
    
    @XmlElement(namespace = "http://td1.com/serveur")
    private boolean statut;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
