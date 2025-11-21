package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateServerRequest", propOrder = {"nom"}, namespace = "http://td1.com/serveur")
@XmlRootElement(name = "CreateServerRequest", namespace = "http://td1.com/serveur")
public class CreateServerRequest {

    @XmlElement(required = true, namespace = "http://td1.com/serveur")
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
