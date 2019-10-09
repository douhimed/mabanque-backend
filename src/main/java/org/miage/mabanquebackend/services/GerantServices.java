package org.miage.mabanquebackend.services;

import java.util.ArrayList;
import java.util.List;

import org.miage.mabanquebackend.dao.AgenceDao;
import org.miage.mabanquebackend.dao.EmployeDao;
import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.Gerant;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GerantServices implements IGerantServices {

	@Autowired
	private AgenceDao agenceDao;
	
	@Autowired
	private EmployeDao employeDao;


	@Override
	public Agence getAgenceByGerant(int idGerant) {
		Employe gerant = this.employeDao.findById(idGerant).get();
		return gerant.getAgence();
	}


	@Override
	public List<Agence> getAllAgences() {
		return this.agenceDao.findAll();
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
