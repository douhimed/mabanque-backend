package ma.jit.proxybanque.spring.services;


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
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.Retrait;
import ma.jit.proxybanque.spring.web.models.Versement;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

/**
 * 
 * <h3>ConseillerServices</h3>
 * <p>Une implémentation de différents services gérer par le conseiller</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
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

		Compte compte = new CompteCourant(20, 1000);
		compte.setCarteType("Premier");
		String code = compte.getCode();
		while (this.compteDao.findByCode(code) != null)
			compte.setCode("");
		this.clientDao.save(client);
		compte.setClient(client);
		this.compteDao.save(compte);
		return client;
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
	
	@Override
	public Compte updateCompte(Compte compte) {
		Compte oldCompte = this.getCompte(compte.getId());
		oldCompte.setCarteType(compte.getCarteType());
		return this.compteDao.save(oldCompte);
	}


	/*** Gestion des operations ***/

	public Compte addOperation(DTOOperation dtoOperation) {
		if (dtoOperation.getType().equals("verser"))
			return this.verser(dtoOperation.getCompteOne(), dtoOperation.getMontant());
		else if (dtoOperation.getType().equals("retirait"))
			return this.retirer(dtoOperation.getCompteOne(), dtoOperation.getMontant(), true);
		else if (dtoOperation.getType().equals("virement")) {
			return this.virment(dtoOperation);
		}
		return this.getCompte(dtoOperation.getCompteOne());
	}

	private double profit(double montant, int conseillerID) {
		double profit = Math.ceil(montant * 5 / 100);
		double newMontant = montant - profit;
		Compte agenceCompte = this.getAgenceByConseiller(conseillerID).getCompte();
		double actualSolde = agenceCompte.getSolde();
		agenceCompte.setSolde(actualSolde + profit);
		this.compteDao.save(agenceCompte);
		return newMontant;
	}

	public Compte verser(int id, double montant) {
		Compte compte = this.getCompte(id);
		Versement versment = new Versement(montant, compte);
		this.operationdao.save(versment);
		compte.setSolde(compte.getSolde() + montant);
		return this.compteDao.save(compte);
	}

	public Compte retirer(int id, double montant, boolean flag) {
		Compte compte = this.getCompte(id);
		if(flag && compte.getSolde()<montant)
			throw new RuntimeException("solde insuffisant");
		Retrait retrait = new Retrait(montant, compte);
		this.operationdao.save(retrait);
		compte.setSolde(compte.getSolde() - montant);
		return this.compteDao.save(compte);
	}

	public Compte virment(DTOOperation dtoOperation) {
		
		if (dtoOperation.getCompteOne() == dtoOperation.getCompteTwo())
			throw new RuntimeException("Interdit sur le meme compte");
		
		Compte cmp = this.getCompte(dtoOperation.getCompteOne());
		if(cmp instanceof CompteCourant && cmp.getSolde() - dtoOperation.getMontant() <= -1000)
			throw new RuntimeException("Le virement a atteint la limite, le virment possible : " + (1000 + cmp.getSolde()));
		
		double newMontant = this.profit(dtoOperation.getMontant(), dtoOperation.getConseillerID());
		double montant = dtoOperation.getMontant();
		retirer(dtoOperation.getCompteOne(), montant + (montant - newMontant), false);
		return verser(dtoOperation.getCompteTwo(), montant);
	}

	/*** Gestion des employes ***/

	@Override
	public Employer getEmploye(int id) {
		return this.employeDao.findById(id).get();
	}

	@Override
	public Employer updateEmploye(DTOEmploye tdoEmp) {
		Employer employe = tdoEmp.buildConseiller();
		employe.setAgence(getAgenceByConseiller(employe.getId()));
		return this.employeDao.save(employe);
	}

	@Override
	public Employer getUser(String username) {
		return this.employeDao.findByUsername(username);
	}

	private Agence getAgenceByConseiller(int idUser) {
		Employer gerant = this.employeDao.findById(idUser).get();
		return gerant.getAgence();
	}

}
