package org.miage.mabanquebackend;

import java.util.Arrays;
import java.util.List;

import org.miage.mabanquebackend.dao.ClientDao;
import org.miage.mabanquebackend.dao.CompteDao;
import org.miage.mabanquebackend.dao.OperationDao;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.CompteCourant;
import org.miage.mabanquebackend.web.models.CompteEpargne;
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

	public static void main(String[] args) {
		SpringApplication.run(MabanqueBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Client One
		Client client1 = new Client("Douhi", "Med", "douhi@gmail.com", "BV El ounia N27", "oujda", "0677232344", 60012);
		Compte c1 = new CompteCourant(15000, 1500);
		c1.setClient(client1);
		Compte c2 = new CompteEpargne(25000, 3);
		c2.setClient(client1);
		List<Compte> comptes1 = Arrays.asList(c1, c2);
		client1.setComptes(comptes1);
		clientDao.save(client1);
		//comptes1.forEach(compte -> compteDao.save(compte));

		// Client Two
		Client client2 = new Client("Riahi", "Azzedine", "riahi@gmail.com", "BV Ouartassi N47", "oujda", "0677232154",
				60012);
		Compte c3 = new CompteCourant(250000, 3000);
		c3.setClient(client2);
		List<Compte> comptes2 = Arrays.asList(c3);
		client2.setComptes(comptes2);
		clientDao.save(client2);
		//comptes2.forEach(compte -> compteDao.save(compte));

		// Client Three
		Client client3 = new Client("Douhi", "Khadija", "khadija@gmail.com", "CGI N45", "oujda", "0673232344", 60060);
		Compte c4 = new CompteEpargne(75000, 4.5);
		c4.setClient(client3);
		List<Compte> comptes3 = Arrays.asList(c4);
		client3.setComptes(comptes3);
		clientDao.save(client3);
		//comptes3.forEach(compte -> compteDao.save(compte));

		compteDao.findAllByClient(client1).forEach(compte -> System.out.println(compte.getSolde()));
	}

}
