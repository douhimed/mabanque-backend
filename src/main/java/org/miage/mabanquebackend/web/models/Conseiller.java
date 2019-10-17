package org.miage.mabanquebackend.web.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Conseiller extends Employe {

	public Conseiller() {
		super();
	}

	public Conseiller(int id) {
		super(id);
	}

	public Conseiller(int id, String nom, String prenom, String username, String password, String email,
			String adresse) {
		super(id, nom, prenom, username, password, email, adresse);
	}

	public Conseiller(String nom, String prenom, String username, String password, String email, String adresse) {
		super(nom, prenom, username, password, email, adresse);
	}

	@Override
	public void setType() {
		this.type = "conseiller";
	}

}
