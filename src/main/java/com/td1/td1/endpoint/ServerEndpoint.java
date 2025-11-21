package com.td1.td1.endpoint;

import com.td1.td1.models.serveur;  // Entité JPA
import com.td1.td1.service.ServerService;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

@Endpoint
@Component
public class ServerEndpoint {

    private static final String NAMESPACE = "http://td1.com/serveur";
    private final ServerService service;

    public ServerEndpoint(ServerService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CreateServerRequest")
    @ResponsePayload
    public CreateServerResponse createServer(@RequestPayload CreateServerRequest req) {
        serveur s = service.createServer(req.getNom());

        CreateServerResponse resp = new CreateServerResponse();
        resp.setId(s.getId());
        resp.setNom(s.getNom());
        resp.setStatut(s.isStatut());
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "GetAllServersRequest")
    @ResponsePayload
    public GetAllServersResponse getAllServers(@RequestPayload GetAllServersRequest req) {
        List<serveur> servers = service.getAllServers();
        GetAllServersResponse resp = new GetAllServersResponse();

        for (serveur s : servers) {
            Serveur srv = new Serveur(); // Classe JAXB générée
            srv.setId(s.getId());
            srv.setNom(s.getNom());
            srv.setStatut(s.isStatut());
            resp.getServers().add(srv);
        }
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "StartServerRequest")
    @ResponsePayload
    public StartServerResponse startServer(@RequestPayload StartServerRequest req) {
        StartServerResponse resp = new StartServerResponse();
        resp.setSuccess(service.startServer(req.getId()).isPresent());
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "StopServerRequest")
    @ResponsePayload
    public StopServerResponse stopServer(@RequestPayload StopServerRequest req) {
        StopServerResponse resp = new StopServerResponse();
        resp.setSuccess(service.stopServer(req.getId()).isPresent());
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "RenameServerRequest")
    @ResponsePayload
    public RenameServerResponse renameServer(@RequestPayload RenameServerRequest req) {
        RenameServerResponse resp = new RenameServerResponse();
        resp.setSuccess(service.renameServer(req.getId(), req.getNom()).isPresent());
        return resp;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "DeleteServerRequest")
    @ResponsePayload
    public DeleteServerResponse deleteServer(@RequestPayload DeleteServerRequest req) {
        DeleteServerResponse resp = new DeleteServerResponse();
        resp.setSuccess(service.deleteServer(req.getId()));
        return resp;
    }
}
