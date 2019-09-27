package org.miage.mabanquebackend.dao;

import java.util.List;

import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

	List<Client> findAllByConseiller(Conseiller conseiller);

}
