package ma.jit.proxybanque.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.jit.proxybanque.spring.dao.AgenceDao;
import ma.jit.proxybanque.spring.dao.ClientDao;
import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.services.exceptions.ServiceExceptions;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.Gerant;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

/**
 * 
 * <h3>GerantServices</h3>
 * <p>Une implémentation de différents services d'un gérant, aussi avec une extention vers les services d'un conseiller</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@Service
@Transactional
public class GerantServices extends ConseillerServices implements IGerantServices {

	@Autowired
	private EmployeDao employeDao;
	
	@Autowired
	private ClientDao clientDao;


	@Autowired
	private IConseillerServices conseillerServices;

	/*** Gestion clients ***/

	public Client getClients(int id) {
		return conseillerServices.getClients(id);
	}

	public void deleteClient(int id) {
		conseillerServices.deleteClient(id);
	}

	public Client addClient(Client client, int conseillerID) throws ServiceExceptions {
		throw new ServiceExceptions("Not Allowed");
	}

	public Client updateClient(Client client, int conseillerID) {
		return conseillerServices.updateClient(client, conseillerID);
	}

	/*** Gestion des operations 
	 * @throws ServiceExceptions ***/

	public Compte addOperation(DTOOperation dtoOperation) throws ServiceExceptions {
		throw new ServiceExceptions("Not Allowed");
	}

	/*** Gestion des comptes ***/

	public Compte getCompte(int id) {
		return conseillerServices.getCompte(id);
	}

	public Compte addCompte(Compte compte, int idClient) throws ServiceExceptions {
		throw new ServiceExceptions("Not Allowed");
	}

	public void deleteCompte(int id) throws ServiceExceptions {
		throw new ServiceExceptions("Not Allowed");
	}

	/*** Gestion des employes ***/


	@Override
	public List<Employer> getEmployesByGerant(int id) {
		return this.employeDao.findByIdResponsable(id);
	}
	
	public Employer getEmploye(int id) {
		return conseillerServices.getEmploye(id);
	}

	public Employer updateEmploye(DTOEmploye tdoEmp) {
		return conseillerServices.updateEmploye(tdoEmp);
	}

	public Employer getUser(String username) {
		return conseillerServices.getUser(username);
	}

	@Override
	public Agence getAgenceByGerant(int idGerant) {
		Employer gerant = this.employeDao.findById(idGerant).get();
		return gerant.getAgence();
	}

	@Override
	public void deleteEmploye(int id) {
		this.employeDao.deleteById(id);
	}


	@Override
	public Employer addEmploye(DTOEmploye tdoEmp, int idGerant) {
		Employer employe = tdoEmp.buildConseiller();
		employe.setAgence(getAgenceByGerant(idGerant));
		return this.employeDao.save(employe);
	}


}
