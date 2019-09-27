package org.miage.mabanquebackend.dao;

import java.util.List;

import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {

	List<Compte> findAllByClient(Client client);
	List<Compte> findAllByClient(int clientId);


}
