package org.miage.mabanquebackend.web.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("agence")
	private Collection<Employe> employes;

	public Agence() {
	}

	public Agence(int id) {
		this.id=id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

}
