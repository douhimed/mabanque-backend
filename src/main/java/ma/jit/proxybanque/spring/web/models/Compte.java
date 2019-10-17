package ma.jit.proxybanque.spring.web.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double solde;
	// @JsonIgnore
	private Date creationDate = new Date();
	private String code = generateCode(7);

	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT")
	@JsonIgnoreProperties("comptes")
	private Client client;
	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("compte")
	private Collection<Operation> operations = new ArrayList<Operation>();
	@OneToOne
	@JoinColumn(name = "agence_id", referencedColumnName = "id", nullable=true)
	@JsonIgnoreProperties("compte")
	private Agence agence;

	public Compte() {
	}

	public Compte(double solde) {
		this();
		this.solde = solde;
	}

	public Compte(double solde, String code) {
		super();
		this.solde = solde;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Collection<Operation> getOperations() {
		return Collections.unmodifiableCollection(operations);
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		if(code.equals("") || code.length() == 0)
			this.code = this.generateCode(7);
	}

	private String generateCode(int lingth) {
		int m = (int) Math.pow(10, lingth - 1);
		return String.valueOf(m + new Random().nextInt(9 * m));
	}
	
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
}
