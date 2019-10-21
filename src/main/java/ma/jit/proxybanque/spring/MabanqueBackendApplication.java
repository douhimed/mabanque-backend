package ma.jit.proxybanque.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.jit.proxybanque.spring.dao.AgenceDao;

import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.services.IParamDashboard;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.Gerant;


@SpringBootApplication
public class MabanqueBackendApplication implements CommandLineRunner {

	@Autowired
	private IParamDashboard params;

	@Autowired
	private EmployeDao employeDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MabanqueBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Agence a1 = new Agence("Agence EL bouraq");
		this.params.addAgance(a1);
		
		Agence a2 = new Agence("Agence Sallam");
		this.params.addAgance(a2);
		
		Employer g1 = new Gerant("DOUHI", "Mohammed", "med", bcryptEncoder.encode("pass"), "douhi@gmail.com", "Oujda LOT Douhi");
		g1.setAgence(a1);
		Employer g2 = new Gerant("RIAHI", "Azzedine", "riahi-azzedine", bcryptEncoder.encode("pass"), "riahi@gmail.com", "Rabat, EL Ouartassi");
		g2.setAgence(a2);
		
		this.employeDao.save(g1);
		this.employeDao.save(g2);
		
		Employer e1 =new Conseiller("test", "test", "test", bcryptEncoder.encode("test"), "test@gmail.com", "oujda");
		e1.setAgence(a1);
		e1.setIdResponsable(g1.getId());
		this.employeDao.save(e1);
		
		 
	}

}
