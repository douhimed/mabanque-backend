package ma.jit.proxybanque.spring.services;

import java.util.List;

import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;

public interface IGerantServices extends IConseillerServices{

	/*** Gestion agence ***/
	
	Agence getAgenceByGerant(int idGerant);
	
	/*** Gestion des employes ***/
	
	List<Employer> getEmployesByGerant(int id);

	void deleteEmploye(int idConseiller,  int idGerant);

	Employer addEmploye(DTOEmploye tdoEmp, int idGerant);

	void deleteEmploye(int id);
	
}
