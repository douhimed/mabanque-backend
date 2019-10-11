package org.miage.mabanquebackend.web.models.tdo;

import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DTOEmploye {

	private int id;
	private String nom, prenom, password, username;
    
	@Autowired
	private PasswordEncoder bcryptEncoder;

	public DTOEmploye() {
	}

	public DTOEmploye(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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

	public Employe buildConseiller() {
		String pass = this.nom.substring(0, 3) + this.prenom.substring(0, 3);
		if (this.password != null && this.password.trim().length() >= 6)
			pass =this.password;
		String username = pass;
		if (this.username != null && this.username.trim().length() >= 6)
			username = this.username;
		Employe emp = new Conseiller(this.nom, this.prenom, username, bcryptEncoder.encode(pass));
		if (this.id != 0)
			emp.setId(this.id);		
		return emp;
	}
	
}
