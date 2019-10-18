package ma.jit.proxybanque.spring.web.models.tdo;

import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.CompteCourant;
import ma.jit.proxybanque.spring.web.models.CompteEpargne;

public class DTOCompte {

	private int id, clientId;
	private double solde, taux, decouvert;
	private String type, codeCompte, carteType;

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

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	
	public String getCarteType() {
		return carteType;
	}
	public void setCarteType(String carteType) {
		this.carteType = carteType;
	}

	public Compte buildCompte() {
		Compte compte;
		if (this.type.equals("cc")) {
			compte = new CompteCourant(solde,1000, this.carteType);
			compte.setCarteType(this.carteType);
		} else {
			compte = new CompteEpargne(solde, 3);
		}
		compte.setId(this.id != 0 ? this.id : 0);
		return compte;
	}
	
}
