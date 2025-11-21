package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllServersResponse", propOrder = {"servers"}, namespace = "http://td1.com/serveur")
@XmlRootElement(name = "GetAllServersResponse", namespace = "http://td1.com/serveur")
public class GetAllServersResponse {

    @XmlElement(name = "server", namespace = "http://td1.com/serveur")
    private List<Serveur> servers;

    public List<Serveur> getServers() {
        if (servers == null) {
            servers = new ArrayList<>();
        }
        return servers;
    }
}
