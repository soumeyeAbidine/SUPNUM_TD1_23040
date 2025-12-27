package com.td1.td1.middleservice.client;

import com.td1.td1.endpoint.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Client SOAP pour consommer le service SOAP existant
 */
@Component
public class SoapClient {

    private WebServiceTemplate webServiceTemplate;
    private static final String NAMESPACE = "http://td1.com/serveur";
    
    @Value("${soap.service.url:http://localhost:8081/ws}")
    private String soapServiceUrl;

    @PostConstruct
    public void init() {
        this.webServiceTemplate = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.td1.td1.endpoint");
        this.webServiceTemplate.setMarshaller(marshaller);
        this.webServiceTemplate.setUnmarshaller(marshaller);
        this.webServiceTemplate.setDefaultUri(soapServiceUrl);
    }

    public CreateServerResponse createServer(String nom) {
        CreateServerRequest request = new CreateServerRequest();
        request.setNom(nom);
        return (CreateServerResponse) webServiceTemplate.marshalSendAndReceive(
            soapServiceUrl,
            request,
            new SoapActionCallback(NAMESPACE + "/CreateServerRequest")
        );
    }

    public GetAllServersResponse getAllServers() {
        GetAllServersRequest request = new GetAllServersRequest();
        return (GetAllServersResponse) webServiceTemplate.marshalSendAndReceive(
            soapServiceUrl,
            request,
            new SoapActionCallback(NAMESPACE + "/GetAllServersRequest")
        );
    }

    public StartServerResponse startServer(Long id) {
        StartServerRequest request = new StartServerRequest();
        request.setId(id);
        return (StartServerResponse) webServiceTemplate.marshalSendAndReceive(
            soapServiceUrl,
            request,
            new SoapActionCallback(NAMESPACE + "/StartServerRequest")
        );
    }

    public StopServerResponse stopServer(Long id) {
        StopServerRequest request = new StopServerRequest();
        request.setId(id);
        return (StopServerResponse) webServiceTemplate.marshalSendAndReceive(
            soapServiceUrl,
            request,
            new SoapActionCallback(NAMESPACE + "/StopServerRequest")
        );
    }

    public RenameServerResponse renameServer(Long id, String nom) {
        RenameServerRequest request = new RenameServerRequest();
        request.setId(id);
        request.setNom(nom);
        return (RenameServerResponse) webServiceTemplate.marshalSendAndReceive(
            soapServiceUrl,
            request,
            new SoapActionCallback(NAMESPACE + "/RenameServerRequest")
        );
    }

    public DeleteServerResponse deleteServer(Long id) {
        DeleteServerRequest request = new DeleteServerRequest();
        request.setId(id);
        return (DeleteServerResponse) webServiceTemplate.marshalSendAndReceive(
            soapServiceUrl,
            request,
            new SoapActionCallback(NAMESPACE + "/DeleteServerRequest")
        );
    }
}

