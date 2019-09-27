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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(MabanqueBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Agence a1 = new Agence();
		Agence a2 = new Agence();

		Employe e1 = new Conseiller("C1", "c1", "c1", "c1");
		e1.setAgence(a1);
		Employe e2 = new Conseiller("C2", "c2", "c2", "c2");
		e2.setAgence(a1);
		Employe e3 = new Conseiller("C3", "c3", "c3", "c3");
		e3.setAgence(a1);
		Employe e4 = new Conseiller("C4", "c4", "c4", "c4");
		e4.setAgence(a2);
		Employe e5 = new Conseiller("C5", "c5", "c5", "c5");
		e5.setAgence(a2);

		Employe g1 = new Gerant("G1", "g1", "g1", "g1");
		g1.setAgence(a1);
		Employe g2 = new Gerant("G2", "g2", "g2", "g2");
		g2.setAgence(a2);

		agenceDao.save(a1);
		agenceDao.save(a2);

		List<Employe> employes = Arrays.asList(e1, e2, e3, e4, e5, g1, g2);
		employes.forEach(e -> employeDao.save(e));

		Client client1 = new Client("Douhi", "Med", "douhi@gmail.com", "BV El ounia N27", "oujda", "0677232344", 60012);
		client1.setConseiller(e1);
		Compte c1 = new CompteCourant(15000, 1500);
		c1.setClient(client1);
		Compte c2 = new CompteEpargne(25000, 3);
		c2.setClient(client1);
		List<Compte> comptes1 = Arrays.asList(c1, c2);
		client1.setComptes(comptes1);
		clientDao.save(client1);

		Client client2 = new Client("Riahi", "Azzedine", "riahi@gmail.com", "BV Ouartassi N47", "oujda", "0677232154",
				60012);
		client2.setConseiller(e1);
		Compte c3 = new CompteCourant(250000, 3000);
		c3.setClient(client2);
		List<Compte> comptes2 = Arrays.asList(c3);
		client2.setComptes(comptes2);
		clientDao.save(client2);

		Client client3 = new Client("Douhi", "Khadija", "khadija@gmail.com", "CGI N45", "oujda", "0673232344", 60060);
		client3.setConseiller(e3);
		Compte c4 = new CompteEpargne(75000, 4.5);
		c4.setClient(client3);
		List<Compte> comptes3 = Arrays.asList(c4);
		client3.setComptes(comptes3);
		clientDao.save(client3);

		List<Client> clients1 = Arrays.asList(client1, client2);
		List<Client> clients2 = Arrays.asList(client3);

	}

}
