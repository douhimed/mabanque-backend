package org.miage.mabanquebackend.web.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant() {
	}

	public CompteCourant(double solde, String code, double decouvert) {
		super(solde, code);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", toString()=" + super.toString() + "]";
	}

}
