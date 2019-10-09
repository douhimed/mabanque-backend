package org.miage.mabanquebackend.web.models.tdo;

import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.CompteCourant;
import org.miage.mabanquebackend.web.models.CompteEpargne;

public class DTOCompte {

	private int id, clientId;
	private double solde, taux, decouvert;
	private String type;

	public DTOCompte() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getClientId() {
		return clientId;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Compte buildCompte() {
		Compte compte;
		if (this.type.equals("cc")) {
			compte = new CompteCourant(this.solde, this.decouvert);
		} else {
			compte = new CompteEpargne(this.solde, this.taux);
		}
		compte.setId(this.id != 0 ? this.id : 0);
		return compte;
	}
}
