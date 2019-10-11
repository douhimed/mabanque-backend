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
import org.miage.mabanquebackend.web.models.CompteCourant;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.Operation;
import org.miage.mabanquebackend.web.models.Retrait;
import org.miage.mabanquebackend.web.models.Versement;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;
import org.miage.mabanquebackend.web.models.tdo.DTOOperation;
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
	public Employe updateEmploye(DTOEmploye tdoEmp) {
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

	public Compte addOperation(DTOOperation dtoOperation) {
		if(dtoOperation.getType().equals("verser"))
			return this.verser(dtoOperation.getCompteOne(), dtoOperation.getMontant());
		else if(dtoOperation.getType().equals("retirait"))
			return this.retirer(dtoOperation.getCompteOne(), dtoOperation.getMontant());
		else if(dtoOperation.getType().equals("verment"))
			return this.virment(dtoOperation.getCompteOne(), dtoOperation.getCompteTwo(), dtoOperation.getMontant());
		return this.getCompte(dtoOperation.getCompteOne());
	}

	public Compte verser(int id, double montant) {
		Compte compte = this.getCompte(id);
		Versement versment = new Versement(montant, compte);
		this.operationdao.save(versment);
		compte.setSolde(compte.getSolde() + montant);
		return this.compteDao.save(compte);
	}

	public Compte retirer(int id, double montant) {
		Compte compte = this.getCompte(id);
		double facilitiesCaisse = 0;
		if(compte instanceof CompteCourant)
			facilitiesCaisse = ((CompteCourant) compte).getDecouvert();
		if(compte.getSolde()+facilitiesCaisse<montant)
			throw new RuntimeException("solde insuffisant");
		Retrait retrait = new Retrait(montant, compte);
		this.operationdao.save(retrait);
		compte.setSolde(compte.getSolde() - montant);
		return this.compteDao.save(compte);		
	}
	
	public Compte virment(int compteOne, int compteTwo, double montant) {
		if(compteOne == compteTwo)
			throw new RuntimeException("Interdit sur le meme compte");
		retirer(compteOne, montant);
		return verser(compteTwo, montant);
	}

	@Override
	public Employe getUser(String username) {
		return this.employeDao.findByUsername(username);
	}
	
	
}
