package org.miage.mabanquebackend.services;


import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.tdo.TDOEmploye;

public interface IConseillerServices {

	Employe getConseiller(int id);

	void deleteClient(int id);

	Employe updateEmploye(TDOEmploye tdoEmp);

	Client getClients(int id);

	Compte getCompte(int id);

	Client addClient(Client client, int conseillerID);

	Compte addCompte(Compte compte, int idClient);

	Client updateClient(Client client, int conseillerID);

	void deleteCompte(int id);

}
