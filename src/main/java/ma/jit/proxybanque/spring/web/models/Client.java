package ma.jit.proxybanque.spring.web.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom, prenom, email, adresse, ville, tel;
	private int codePostal;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("client")
	private Collection<Compte> comptes;
	@ManyToOne
	@JoinColumn(name = "CODE_EMPLOYE")
	@JsonIgnoreProperties("clients")
	private Employe employe;

	public Client() {
	}

	public Client(int id) {
		this.id = id;
	}

	public Client(String nom, String prenom, String email, String adresse, String ville, String tel, int codePostal) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.tel = tel;
		this.codePostal = codePostal;
	}

	public Client(int id, String nom, String prenom, String email, String adresse, String ville, String tel,
			int codePostal) {
		this(nom, prenom, email, adresse, ville, tel, codePostal);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
