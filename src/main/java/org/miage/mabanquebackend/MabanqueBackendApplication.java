package org.miage.mabanquebackend;

import java.util.Arrays;
import java.util.List;

import org.miage.mabanquebackend.dao.AgenceDao;
import org.miage.mabanquebackend.dao.ClientDao;
import org.miage.mabanquebackend.dao.CompteDao;
import org.miage.mabanquebackend.dao.EmployeDao;
import org.miage.mabanquebackend.dao.OperationDao;
import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.CompteCourant;
import org.miage.mabanquebackend.web.models.CompteEpargne;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.Gerant;
import org.miage.mabanquebackend.web.models.Operation;
import org.miage.mabanquebackend.web.models.Retrait;
import org.miage.mabanquebackend.web.models.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MabanqueBackendApplication implements CommandLineRunner {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private CompteDao compteDao;

	@Autowired
	private OperationDao operationDao;

	@Autowired
	private AgenceDao agenceDao;

	@Autowired
	private EmployeDao employeDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MabanqueBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Agence a1 = new Agence();
		Agence a2 = new Agence();
		this.agenceDao.save(a1);
		this.agenceDao.save(a2);
		
		Employe g1 = new Gerant("DOUHI", "Mohammed", "med-douhi", bcryptEncoder.encode("pass"), "douhi@gmail.com", "Oujda LOT Douhi");
		g1.setAgence(a1);
		Employe g2 = new Gerant("RIAHI", "Azzedine", "riahi-azzedine", bcryptEncoder.encode("pass"), "riahi@gmail.com", "Rabat, EL Ouartassi");
		g2.setAgence(a2);
		
		this.employeDao.save(g1);
		this.employeDao.save(g2);
	
	}

}
