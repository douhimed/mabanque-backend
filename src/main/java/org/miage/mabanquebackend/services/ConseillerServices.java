package org.miage.mabanquebackend.services;

import java.util.List;

import javax.persistence.IdClass;

import org.miage.mabanquebackend.dao.ClientDao;
import org.miage.mabanquebackend.dao.CompteDao;
import org.miage.mabanquebackend.dao.EmployeDao;
import org.miage.mabanquebackend.dao.OperationDao;
import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.Operation;
import org.miage.mabanquebackend.web.models.tdo.TDOEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConseillerServices implements IConseillerServices {

	@Autowired
	private EmployeDao employeDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private OperationDao operationdao;

	@Autowired
	private CompteDao compteDao;

	
	@Override
	public Employe getConseiller(int id) {
		return this.employeDao.findById(id).get();
		
	}

	@Override
	public void deleteClient(int id) {
		this.clientDao.deleteById(id);
	}

	@Override
	public Employe updateEmploye(TDOEmploye tdoEmp) {
		Employe employe = tdoEmp.buildConseiller();
		employe.setAgence(getAgenceByConseiller(employe.getId()));
		return this.employeDao.save(employe);
	}

	private Agence getAgenceByConseiller(int idUser) {
		Employe gerant = this.employeDao.findById(idUser).get();
		return gerant.getAgence();
	}

	@Override
	public Client getClients(int id) {
		return this.clientDao.findById(id).get();
	}

	@Override
	public Compte getCompte(int id) {
		return this.compteDao.findById(id).get();
	}

	@Override
	public Client addClient(Client client, int conseillerID) {
		client.setConseiller(this.getConseiller(conseillerID));
		return this.clientDao.save(client);
	}

	@Override
	public Compte addCompte(Compte compte, int idClient) {
		compte.setClient(this.getClients(idClient));
		return this.compteDao.save(compte);
	}

	@Override
	public Client updateClient(Client client, int conseillerID) {
		client.setConseiller(this.getConseiller(conseillerID));
		return this.clientDao.save(client);
	}

	@Override
	public void deleteCompte(int id) {
		this.compteDao.deleteById(id);		
	}


}
