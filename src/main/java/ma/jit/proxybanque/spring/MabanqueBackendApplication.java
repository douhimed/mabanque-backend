package ma.jit.proxybanque.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.jit.proxybanque.spring.dao.AgenceDao;

import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Employe;
import ma.jit.proxybanque.spring.web.models.Gerant;


@SpringBootApplication
public class MabanqueBackendApplication implements CommandLineRunner {

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
