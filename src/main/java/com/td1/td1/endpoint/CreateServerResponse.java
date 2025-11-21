package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateServerResponse", propOrder = {"id", "nom", "statut"}, namespace = "http://td1.com/serveur")
@XmlRootElement(name = "CreateServerResponse", namespace = "http://td1.com/serveur")
public class CreateServerResponse {

    @XmlElement(namespace = "http://td1.com/serveur")
    private long id;
    
    @XmlElement(required = true, namespace = "http://td1.com/serveur")
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
