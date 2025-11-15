package com.td1.td1.repository;

import com.td1.td1.models.serveur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<serveur, Long> {
}
