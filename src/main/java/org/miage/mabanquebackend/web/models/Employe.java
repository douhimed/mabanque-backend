package org.miage.mabanquebackend.web.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_EMPLOYE", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom, prenom, username;
	@JsonIgnore
	private String password;
	@ManyToOne
	@JoinColumn(name = "CODE_AGENCE")
	@JsonIgnoreProperties("employes")
	private Agence agence;

	public Employe() {
	}

	public Employe(int id) {
		super();
		this.id = id;
	}

	public Employe(String nom, String prenom, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}

	public Employe(int id, String nom, String prenom, String username, String password) {
		this(nom, prenom, username, password);
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		// this.password = new BCryptPasswordEncoder().encode(password);
		this.password = password;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public abstract void setClients(Collection<Client> clients) throws Exception;

}
