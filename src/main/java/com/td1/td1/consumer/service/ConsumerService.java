package com.td1.td1.consumer.service;

import com.td1.td1.consumer.client.MiddleServiceRestClient;
import com.td1.td1.middleservice.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service consommateur qui utilise le middle-service REST
 * N'interagit pas directement avec le service SOAP
 */
@Service
public class ConsumerService {

    private final MiddleServiceRestClient restClient;

    public ConsumerService(MiddleServiceRestClient restClient) {
        this.restClient = restClient;
    }

    public ServerDTO createServer(CreateServerRequestDTO request) {
        return restClient.createServer(request);
    }

    public List<ServerDTO> getAllServers() {
        return restClient.getAllServers();
    }

    public ActionResponseDTO startServer(Long id) {
        return restClient.startServer(id);
    }

    public ActionResponseDTO stopServer(Long id) {
        return restClient.stopServer(id);
    }

    public ActionResponseDTO renameServer(Long id, RenameServerRequestDTO request) {
        return restClient.renameServer(id, request);
    }

    public ActionResponseDTO deleteServer(Long id) {
        return restClient.deleteServer(id);
    }
}

