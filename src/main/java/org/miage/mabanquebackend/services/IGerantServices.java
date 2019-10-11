package org.miage.mabanquebackend.services;

import java.util.List;

import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;

public interface IGerantServices extends IConseillerServices{

	/*** Gestion agence ***/
	
	Agence getAgenceByGerant(int idGerant);
	
	/*** Gestion des employes ***/

	void deleteEmploye(int id);

	Employe addEmploye(DTOEmploye tdoEmp, int idGerant);
	
}
