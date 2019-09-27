package org.miage.mabanquebackend.dao;

import java.util.List;

import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {

	List<Operation> findAllByCompte(Compte compte);

}
