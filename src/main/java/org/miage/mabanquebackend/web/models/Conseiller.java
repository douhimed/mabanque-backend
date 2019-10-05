package org.miage.mabanquebackend.web.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("C")
public class Conseiller extends Employe {

	@OneToMany(mappedBy = "conseiller", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("conseiller")
	private Collection<Client> clients = new ArrayList<Client>();
	
	public Conseiller() {
		super();
	}

	public Conseiller(int id, String nom, String prenom, String login, String password) {
		super(id, nom, prenom, login, password);
	}

	public Conseiller(int id) {
		super(id);
	}

	public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}	
	
	public Collection<Client> getClients() {
		return clients;
	}
	
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	
	public boolean addClient(Client client) {
		return this.clients.add(client);
	}
}
