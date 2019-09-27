package org.miage.mabanquebackend.services;

import java.util.List;

import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Operation;

public interface IConseillerServices {
	
	Client getClient(int id);
	List<Client> getClientsByConseiller(Conseiller conseiller);
	boolean addClient(Client client);
	Client deleteClient(int clientId);
	
	boolean addCompte(Compte compte);
	Compte deleteCompte(int compteId);
	List<Operation> getOperationsByCompte(Compte compte);
	
	public void verser(int idCompteOne, double montant);
	public void retirer(int idCompteOne, double montant);
	public void virment(int idCompteOne, int idCompteTwo, double montant);
	
}
