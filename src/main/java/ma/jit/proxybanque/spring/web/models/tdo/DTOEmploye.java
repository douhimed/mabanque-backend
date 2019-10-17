package ma.jit.proxybanque.spring.web.models.tdo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employe;

public class DTOEmploye {

	private int id;
	private String nom, prenom, password, username, email, adresse;

	public DTOEmploye() {
	}

	public DTOEmploye(String nom, String prenom, String email, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employe buildConseiller() {
		String pass = this.nom.substring(0, 2) + this.prenom.substring(0, 2);
		if (this.password != null && this.password.trim().length() >= 6)
			pass = this.password;
		String username = pass;
		if (this.username != null && this.username.trim().length() >= 2)
			username = this.username;
		Employe emp = new Conseiller(this.nom, this.prenom, username, new BCryptPasswordEncoder().encode(pass), this.email, this.adresse);
		if (this.id != 0)
			emp.setId(this.id);
		return emp;
	}

}
