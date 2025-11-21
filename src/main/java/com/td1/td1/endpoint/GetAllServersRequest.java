package com.td1.td1.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllServersRequest", namespace = "http://td1.com/serveur")
@XmlRootElement(name = "GetAllServersRequest", namespace = "http://td1.com/serveur")
public class GetAllServersRequest {
    // pas de champs nécessaires
}
