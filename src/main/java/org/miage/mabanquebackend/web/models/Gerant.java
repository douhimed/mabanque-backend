package org.miage.mabanquebackend.web.models;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("G")
public class Gerant extends Employe {

	public Gerant() {
		super();
	}

	public Gerant(int id, String nom, String prenom, String login, String password) {
		super(id, nom, prenom, login, password);
	}

	public Gerant(int id) {
		super(id);
	}

	public Gerant(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}

	@Override
	public void setClients(Collection<Client> clients) throws Exception {
		throw new Exception("A manager Cannot add a client");
	}
	
	

}
