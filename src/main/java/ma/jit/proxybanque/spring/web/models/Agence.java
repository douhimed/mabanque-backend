package ma.jit.proxybanque.spring.web.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("agence")
	private Collection<Employer> employes;
	@OneToOne(mappedBy = "agence")
	@JsonIgnoreProperties("agence")
	private Compte compte;
	private Date creationDate;

	public Agence() {
	}

	public Agence(int id) {
		this();
		this.id = id;
	}

	public Agence(String name) {
		this();
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employer> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employer> employes) {
		this.employes = employes;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
