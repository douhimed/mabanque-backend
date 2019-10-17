package ma.jit.proxybanque.spring.web.models;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPERATION", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dateOperation = new Date();
	private double montant;
	@ManyToOne
	@JoinColumn(name = "NUM_COMPTE")
	@JsonIgnoreProperties("operations")
	private Compte compte;
	protected String type;

	public Operation() {
		this.setType();
	}

	public Operation(double montant) {
		this();
		this.montant = montant;
	}

	public Operation(double montant, Compte compte) {
		this();
		this.montant = montant;
		this.compte = compte;

	}

	public Operation(int id, Date dateOperation, double montant, Compte compte) {
		this(montant, compte);
		this.id = id;
		this.dateOperation = dateOperation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getType() {
		return type;
	}

	public abstract void setType();

}
