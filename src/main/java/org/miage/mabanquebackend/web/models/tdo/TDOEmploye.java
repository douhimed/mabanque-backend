package org.miage.mabanquebackend.web.models.tdo;

import java.util.ArrayList;

import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.Employe;

public class TDOEmploye {

	private int id;
	private String nom, prenom, password, login;

	public TDOEmploye() {
	}

	public TDOEmploye(String nom, String prenom) {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employe buildConseiller() {
		Employe emp = new Conseiller();
		if (this.id != 0)
			emp.setId(this.id);
		emp.setNom(this.nom);
		emp.setPrenom(this.prenom);
		emp.setPassword(this.nom.substring(0, 3) + this.prenom.substring(0, 3));
		if (this.password != null && this.password.trim().length() >= 6)
			emp.setPassword(this.password);
		emp.setLogin(emp.getPassword());
		if (this.login != null && this.login.trim().length() >= 6)
			emp.setLogin(this.login);
		return emp;
	}

}
