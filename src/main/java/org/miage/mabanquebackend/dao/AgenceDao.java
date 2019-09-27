package org.miage.mabanquebackend.dao;

import org.miage.mabanquebackend.web.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceDao extends JpaRepository<Agence, Integer> {

}
