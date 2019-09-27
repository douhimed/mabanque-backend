package org.miage.mabanquebackend.dao;

import org.miage.mabanquebackend.web.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Integer> {

}
