// Service
package com.td1.td1.service;

import com.td1.td1.models.serveur;
import java.util.List;
import java.util.Optional;

public interface ServerService {
    serveur createServer(String nom);
    List<serveur> getAllServers();
    Optional<serveur> renameServer(Long id, String nom);
    Optional<Boolean> getServerStatus(Long id);
    Optional<serveur> startServer(Long id);
    Optional<serveur> stopServer(Long id);
    boolean deleteServer(Long id);
}
