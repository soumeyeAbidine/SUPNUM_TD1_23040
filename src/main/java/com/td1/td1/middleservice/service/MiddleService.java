package com.td1.td1.middleservice.service;

import com.td1.td1.endpoint.Serveur;
import com.td1.td1.middleservice.client.SoapClient;
import com.td1.td1.middleservice.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service intermédiaire qui transforme les appels SOAP en REST
 */
@Service
public class MiddleService {

    private final SoapClient soapClient;

    public MiddleService(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    public ServerDTO createServer(CreateServerRequestDTO request) {
        var soapResponse = soapClient.createServer(request.getNom());
        return new ServerDTO(
            soapResponse.getId(),
            soapResponse.getNom(),
            soapResponse.isStatut()
        );
    }

    public List<ServerDTO> getAllServers() {
        var soapResponse = soapClient.getAllServers();
        List<ServerDTO> servers = new ArrayList<>();
        
        for (Serveur s : soapResponse.getServers()) {
            servers.add(new ServerDTO(
                s.getId(),
                s.getNom(),
                s.isStatut()
            ));
        }
        
        return servers;
    }

    public ActionResponseDTO startServer(Long id) {
        var soapResponse = soapClient.startServer(id);
        return new ActionResponseDTO(
            soapResponse.isSuccess(),
            soapResponse.isSuccess() ? "Serveur démarré avec succès" : "Échec du démarrage du serveur"
        );
    }

    public ActionResponseDTO stopServer(Long id) {
        var soapResponse = soapClient.stopServer(id);
        return new ActionResponseDTO(
            soapResponse.isSuccess(),
            soapResponse.isSuccess() ? "Serveur arrêté avec succès" : "Échec de l'arrêt du serveur"
        );
    }

    public ActionResponseDTO renameServer(Long id, RenameServerRequestDTO request) {
        var soapResponse = soapClient.renameServer(id, request.getNom());
        return new ActionResponseDTO(
            soapResponse.isSuccess(),
            soapResponse.isSuccess() ? "Serveur renommé avec succès" : "Échec du renommage du serveur"
        );
    }

    public ActionResponseDTO deleteServer(Long id) {
        var soapResponse = soapClient.deleteServer(id);
        return new ActionResponseDTO(
            soapResponse.isSuccess(),
            soapResponse.isSuccess() ? "Serveur supprimé avec succès" : "Échec de la suppression du serveur"
        );
    }
}

