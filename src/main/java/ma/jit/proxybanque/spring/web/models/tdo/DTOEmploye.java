package ma.jit.proxybanque.spring.web.models.tdo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employer;

public class DTOEmploye {

	private int id, idResponsable;
	private String nom, prenom, password, username, email, adresse;

	public DTOEmploye() {
	}

	public DTOEmploye(String nom, String prenom, String email, String adresse, int idResponsable) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.idResponsable = idResponsable;
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

	public int getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}

	public Employer buildConseiller() {
		Employer emp = new Conseiller(this.nom, this.prenom, this.username, new BCryptPasswordEncoder().encode(this.password),
				this.email, this.adresse);
		emp.setIdResponsable(this.idResponsable);
		if (this.id != 0)
			emp.setId(this.id);
		return emp;
	}

}
