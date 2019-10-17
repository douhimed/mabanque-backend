package org.miage.mabanquebackend.services;

import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;
import org.miage.mabanquebackend.web.models.tdo.DTOOperation;

public interface IConseillerServices {

	/*** Gestion des Clients ***/

	Client getClients(int id);

	void deleteClient(int id);

	Client updateClient(Client client, int employeId);

	Client addClient(Client client, int employeId);

	/*** Gestion des comptes ***/

	Compte getCompte(int id);

	Compte addCompte(Compte compte, int idClient);

	void deleteCompte(int id);

	/*** Gestion des operations ***/

	Compte addOperation(DTOOperation dtoOperation);

	/*** Gestion des employes ***/

	Employe getEmploye(int id);

	Employe updateEmploye(DTOEmploye tdoEmp);

	Employe getUser(String username);

}
