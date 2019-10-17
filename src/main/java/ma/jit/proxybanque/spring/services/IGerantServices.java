package ma.jit.proxybanque.spring.services;

import java.util.List;

import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Employe;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;

public interface IGerantServices extends IConseillerServices{

	/*** Gestion agence ***/
	
	Agence getAgenceByGerant(int idGerant);
	
	/*** Gestion des employes ***/
	
	List<Employe> getEmployesByGerant(int id);

	void deleteEmploye(int id);

	Employe addEmploye(DTOEmploye tdoEmp, int idGerant);
	
}
