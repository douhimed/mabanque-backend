package org.miage.mabanquebackend.services;

import java.util.List;

import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;

public interface IGerantServices{

	Agence getAgenceByGerant(int idGerant);

	List<Agence> getAllAgences();

	void deleteEmploye(int id);

	Employe addEmploye(DTOEmploye tdoEmp, int idGerant);
	
}
