package org.miage.mabanquebackend.services;


import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;
import org.miage.mabanquebackend.web.models.tdo.DTOOperation;

public interface IConseillerServices {

	Employe getConseiller(int id);

	void deleteClient(int id);

	Employe updateEmploye(DTOEmploye tdoEmp);

	Client getClients(int id);

	Compte getCompte(int id);

	Client addClient(Client client, int conseillerID);

	Compte addCompte(Compte compte, int idClient);

	Client updateClient(Client client, int conseillerID);

	void deleteCompte(int id);

	Compte addOperation(DTOOperation dtoOperation);

	Employe getUser(String username);

}
