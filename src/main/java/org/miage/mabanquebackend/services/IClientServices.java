package org.miage.mabanquebackend.services;

import java.util.List;

import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Operation;

public interface IClientServices {
	
	Client getClient(int clientId);
	List<Compte> getComptesByClient(Client client);	
	List<Operation> getOperationsByCompte(Compte compte);
	
}
