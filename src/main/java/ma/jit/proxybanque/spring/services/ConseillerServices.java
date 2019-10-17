package ma.jit.proxybanque.spring.services;

import java.util.List;

import javax.persistence.IdClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.jit.proxybanque.spring.dao.ClientDao;
import ma.jit.proxybanque.spring.dao.CompteDao;
import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.dao.OperationDao;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.CompteCourant;
import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employe;
import ma.jit.proxybanque.spring.web.models.Operation;
import ma.jit.proxybanque.spring.web.models.Retrait;
import ma.jit.proxybanque.spring.web.models.Versement;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

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

	/*** Gestion des Clients ***/

	@Override
	public Client getClients(int id) {
		return this.clientDao.findById(id).get();
	}

	@Override
	public void deleteClient(int id) {
		this.clientDao.deleteById(id);
	}

	@Override
	public Client addClient(Client client, int employeId) {
		client.setEmploye(this.getEmploye(employeId));
		return this.clientDao.save(client);
	}

	@Override
	public Client updateClient(Client client, int employeId) {
		client.setEmploye(this.getEmploye(employeId));
		return this.clientDao.save(client);
	}

	/*** Gestion des comptes ***/

	@Override
	public Compte getCompte(int id) {
		return this.compteDao.findById(id).get();
	}

	@Override
	public Compte addCompte(Compte compte, int idClient) {
		compte.setClient(this.getClients(idClient));
		return this.compteDao.save(compte);
	}

	@Override
	public void deleteCompte(int id) {
		this.compteDao.deleteById(id);
	}

	/*** Gestion des operations ***/

	public Compte addOperation(DTOOperation dtoOperation) {
		if (dtoOperation.getType().equals("verser"))
			return this.verser(dtoOperation.getCompteOne(), dtoOperation.getMontant());
		else if (dtoOperation.getType().equals("retirait"))
			return this.retirer(dtoOperation.getCompteOne(), dtoOperation.getMontant());
		else if (dtoOperation.getType().equals("virment"))
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
		if (compte instanceof CompteCourant)
			facilitiesCaisse = ((CompteCourant) compte).getDecouvert();
		if (compte.getSolde() + facilitiesCaisse < montant)
			throw new RuntimeException("solde insuffisant");
		Retrait retrait = new Retrait(montant, compte);
		this.operationdao.save(retrait);
		compte.setSolde(compte.getSolde() - montant);
		return this.compteDao.save(compte);
	}

	public Compte virment(int compteOne, int compteTwo, double montant) {
		if (compteOne == compteTwo)
			throw new RuntimeException("Interdit sur le meme compte");
		retirer(compteOne, montant);
		return verser(compteTwo, montant);
	}

	/*** Gestion des employes ***/

	@Override
	public Employe getEmploye(int id) {
		return this.employeDao.findById(id).get();
	}

	@Override
	public Employe updateEmploye(DTOEmploye tdoEmp) {
		Employe employe = tdoEmp.buildConseiller();
		employe.setAgence(getAgenceByConseiller(employe.getId()));
		return this.employeDao.save(employe);
	}

	@Override
	public Employe getUser(String username) {
		return this.employeDao.findByUsername(username);
	}

	private Agence getAgenceByConseiller(int idUser) {
		Employe gerant = this.employeDao.findById(idUser).get();
		return gerant.getAgence();
	}

}
