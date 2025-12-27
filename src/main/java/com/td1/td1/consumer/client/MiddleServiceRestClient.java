package com.td1.td1.consumer.client;

import com.td1.td1.middleservice.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Client REST pour consommer le middle-service
 */
@Component
public class MiddleServiceRestClient {

    private final RestTemplate restTemplate;
    
    @Value("${middle.service.url:http://localhost:8081/api/servers}")
    private String middleServiceUrl;

    public MiddleServiceRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ServerDTO createServer(CreateServerRequestDTO request) {
        ResponseEntity<ServerDTO> response = restTemplate.postForEntity(
            middleServiceUrl,
            request,
            ServerDTO.class
        );
        return response.getBody();
    }

    public List<ServerDTO> getAllServers() {
        ResponseEntity<List<ServerDTO>> response = restTemplate.exchange(
            middleServiceUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ServerDTO>>() {}
        );
        return response.getBody();
    }

    public ActionResponseDTO startServer(Long id) {
        ResponseEntity<ActionResponseDTO> response = restTemplate.postForEntity(
            middleServiceUrl + "/" + id + "/start",
            null,
            ActionResponseDTO.class
        );
        return response.getBody();
    }

    public ActionResponseDTO stopServer(Long id) {
        ResponseEntity<ActionResponseDTO> response = restTemplate.postForEntity(
            middleServiceUrl + "/" + id + "/stop",
            null,
            ActionResponseDTO.class
        );
        return response.getBody();
    }

    public ActionResponseDTO renameServer(Long id, RenameServerRequestDTO request) {
        ResponseEntity<ActionResponseDTO> response = restTemplate.exchange(
            middleServiceUrl + "/" + id + "/rename",
            HttpMethod.PUT,
            new org.springframework.http.HttpEntity<>(request),
            ActionResponseDTO.class
        );
        return response.getBody();
    }

    public ActionResponseDTO deleteServer(Long id) {
        ResponseEntity<ActionResponseDTO> response = restTemplate.exchange(
            middleServiceUrl + "/" + id,
            HttpMethod.DELETE,
            null,
            ActionResponseDTO.class
        );
        return response.getBody();
    }
}

