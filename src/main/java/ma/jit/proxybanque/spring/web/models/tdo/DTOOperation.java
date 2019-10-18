package ma.jit.proxybanque.spring.web.models.tdo;

import ma.jit.proxybanque.spring.web.models.Operation;
import ma.jit.proxybanque.spring.web.models.Retrait;
import ma.jit.proxybanque.spring.web.models.Versement;

public class DTOOperation {

	private int id, compteOne, compteTwo, conseillerID;
	private double montant;
	private String type;

	public DTOOperation() {
	}

	public DTOOperation(int id) {
		this.id = id;
	}

	public DTOOperation(int id, int compteOne, int compteTwo, double montant, String type) {
		this(id);
		this.compteOne = compteOne;
		this.compteTwo = compteTwo;
		this.montant = montant;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompteOne() {
		return compteOne;
	}

	public void setCompteOne(int compteOne) {
		this.compteOne = compteOne;
	}

	public int getCompteTwo() {
		return compteTwo;
	}

	public void setCompteTwo(int compteTwo) {
		this.compteTwo = compteTwo;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getConseillerID() {
		return conseillerID;
	}

	public void setConseillerID(int conseillerID) {
		this.conseillerID = conseillerID;
	}

	public Operation buildOperation() {
		Operation operation;
		if (this.type.equals("virser"))
			operation = new Versement(this.montant);
		else
			operation = new Retrait(montant);
		operation.setType();
		return operation;
	}

}
