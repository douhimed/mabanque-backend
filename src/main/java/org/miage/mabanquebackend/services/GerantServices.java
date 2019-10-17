package org.miage.mabanquebackend.services;

import java.util.ArrayList;
import java.util.List;

import org.miage.mabanquebackend.dao.AgenceDao;
import org.miage.mabanquebackend.dao.EmployeDao;
import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.Gerant;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;
import org.miage.mabanquebackend.web.models.tdo.DTOOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GerantServices extends ConseillerServices implements IGerantServices {

	@Autowired
	private AgenceDao agenceDao;

	@Autowired
	private EmployeDao employeDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private IConseillerServices conseillerServices;

	/*** Gestion clients ***/

	public Client getClients(int id) {
		return conseillerServices.getClients(id);
	}

	public void deleteClient(int id) {
		conseillerServices.deleteClient(id);
	}

	public Client addClient(Client client, int conseillerID) {
		return conseillerServices.addClient(client, conseillerID);
	}

	public Client updateClient(Client client, int conseillerID) {
		return conseillerServices.updateClient(client, conseillerID);
	}

	/*** Gestion des operations ***/

	public Compte addOperation(DTOOperation dtoOperation) {
		return conseillerServices.addOperation(dtoOperation);
	}

	/*** Gestion des comptes ***/

	public Compte getCompte(int id) {
		return conseillerServices.getCompte(id);
	}

	public Compte addCompte(Compte compte, int idClient) {
		return conseillerServices.addCompte(compte, idClient);
	}

	public void deleteCompte(int id) {
		conseillerServices.deleteCompte(id);
	}

	/*** Gestion des employes ***/

	public Employe getEmploye(int id) {
		return conseillerServices.getEmploye(id);
	}

	public Employe updateEmploye(DTOEmploye tdoEmp) {
		return conseillerServices.updateEmploye(tdoEmp);
	}

	public Employe getUser(String username) {
		return conseillerServices.getUser(username);
	}

	@Override
	public Agence getAgenceByGerant(int idGerant) {
		Employe gerant = this.employeDao.findById(idGerant).get();
		return gerant.getAgence();
	}

	@Override
	public void deleteEmploye(int id) {
		this.employeDao.deleteById(id);
	}

	@Override
	public Employe addEmploye(DTOEmploye tdoEmp, int idGerant) {
		Employe employe = tdoEmp.buildConseiller();
		employe.setAgence(getAgenceByGerant(idGerant));
		return this.employeDao.save(employe);
	}

}
