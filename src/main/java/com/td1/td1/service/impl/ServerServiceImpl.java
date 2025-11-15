// Implémentation
package com.td1.td1.service.impl;

import com.td1.td1.models.serveur;
import com.td1.td1.repository.ServerRepository;
import com.td1.td1.service.ServerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public serveur createServer(String nom) {
        serveur s = new serveur(nom);
        return serverRepository.save(s);
    }

    @Override
    public List<serveur> getAllServers() {
        return serverRepository.findAll();
    }

    @Override
    public Optional<serveur> renameServer(Long id, String nouveauNom) {
        return serverRepository.findById(id).map(s -> {
            s.setNom(nouveauNom);
            return serverRepository.save(s);
        });
    }

    @Override
    public Optional<Boolean> getServerStatus(Long id) {
        return serverRepository.findById(id).map(serveur::isStatut);
    }

    @Override
    public Optional<serveur> startServer(Long id) {
        return serverRepository.findById(id).map(s -> {
            s.setStatut(true);
            return serverRepository.save(s);
        });
    }

    @Override
    public Optional<serveur> stopServer(Long id) {
        return serverRepository.findById(id).map(s -> {
            s.setStatut(false);
            return serverRepository.save(s);
        });
    }

    @Override
    public boolean deleteServer(Long id) {
        Optional<serveur> s = serverRepository.findById(id);
        if (s.isPresent() && !s.get().isStatut()) {
            serverRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
