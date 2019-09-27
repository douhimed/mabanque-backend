package org.miage.mabanquebackend.services;

import java.util.List;

import org.miage.mabanquebackend.dao.ClientDao;
import org.miage.mabanquebackend.dao.CompteDao;
import org.miage.mabanquebackend.dao.OperationDao;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServices implements IClientServices {

	@Autowired
	private CompteDao compteDao;

	@Autowired
	private OperationDao operationDao;
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public List<Compte> getComptesByClient(Client client) {
		return compteDao.findAllByClient(client);
	}

	@Override
	public List<Operation> getOperationsByCompte(Compte compte) {
		return operationDao.findAllByCompte(compte);
	}

	@Override
	public Client getClient(int id) {
		return this.clientDao.findById(id).orElseGet(null);
	}

}
