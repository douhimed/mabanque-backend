package ma.jit.proxybanque.spring.web.models.tdo;

import ma.jit.proxybanque.spring.web.models.Client;

/**
 * <h3>DTOClient</h3>
 * <p>Le DTO est un design pattern JEE permet l'echange des models ayant que des preprietes primitive</p>
 * <p>Le client peut envoyer des données selon leur besoin, par exemple envoyer que le numéro de télephone</p>
 * <p>Aussi nous permet de recuperer que les données se qu'on a besoin, le client peut envoyer des données corrompues, 
 * d'où avec les méthodes de fabrication on crie des objets bien définie</p>
 * 
 * @author MED DOUHI
 * @version 1.0
 */
public class DTOClient {

	private int id, codePostal, conseillerID;
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

	public int getConseillerID() {
		return conseillerID;
	}

	public void setConseillerID(int conseillerID) {
		this.conseillerID = conseillerID;
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
