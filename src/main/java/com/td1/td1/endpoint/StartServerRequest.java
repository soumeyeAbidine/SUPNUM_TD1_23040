package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StartServerRequest", propOrder = {"id"}, namespace = "http://td1.com/serveur")
@XmlRootElement(name = "StartServerRequest", namespace = "http://td1.com/serveur")
public class StartServerRequest {

    @XmlElement(namespace = "http://td1.com/serveur")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

