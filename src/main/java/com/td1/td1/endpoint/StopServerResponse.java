package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StopServerResponse", propOrder = {"success"}, namespace = "http://td1.com/serveur")
@XmlRootElement(name = "StopServerResponse", namespace = "http://td1.com/serveur")
public class StopServerResponse {

    @XmlElement(namespace = "http://td1.com/serveur")
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}



