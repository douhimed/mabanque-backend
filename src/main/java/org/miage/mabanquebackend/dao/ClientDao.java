package org.miage.mabanquebackend.dao;

import org.miage.mabanquebackend.web.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

}
