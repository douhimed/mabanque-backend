package org.miage.mabanquebackend.dao;


import org.miage.mabanquebackend.web.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
