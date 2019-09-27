package org.miage.mabanquebackend.services;

import java.util.List;

import org.miage.mabanquebackend.dao.ClientDao;
import org.miage.mabanquebackend.dao.OperationDao;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConseillerServices implements IConseillerServices {

	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private OperationDao operationdao;
	
	@Override
	public Client getClient(int id) {
		return clientDao.findById(id).orElseGet(null);
	}

	
	@Override
	public List<Client> getClientsByConseiller(Conseiller conseiller) {
		return clientDao.findAllByConseiller(conseiller);
	}

	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client deleteClient(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCompte(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compte deleteCompte(int compteId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Operation> getOperationsByCompte(Compte compte) {
		return operationdao.findAllByCompte(compte);
	}

	
	@Override
	public void verser(int idCompteOne, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retirer(int idCompteOne, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void virment(int idCompteOne, int idCompteTwo, double montant) {
		// TODO Auto-generated method stub

	}

}
