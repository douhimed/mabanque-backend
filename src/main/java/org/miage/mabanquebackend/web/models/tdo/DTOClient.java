package org.miage.mabanquebackend.web.models.tdo;

import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Conseiller;

public class DTOClient {

	private int id, codePostal, employeID;
	private String nom, prenom, email, tel, ville, adresse;

	public DTOClient() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getEmployeID() {
		return employeID;
	}

	public void setEmployeID(int employeID) {
		this.employeID = employeID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Client buildClient() {
		Client client = new Client(this.nom, this.prenom, this.email, this.adresse, this.ville, this.tel,
				this.codePostal);
		client.setId(this.id != 0 ? this.id : 0);
		return client;
	}

}
