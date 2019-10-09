package org.miage.mabanquebackend.web.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement() {
		super();
	}

	public Versement(double montant) {
		super(montant);
	}

	public Versement(double montant, Compte compte) {
		super(montant, compte);
	}

	public Versement(int id, Date dateOperation, double montant, Compte compte) {
		super(id, dateOperation, montant, compte);
	}

	@Override
	public void setType() {
		this.type = "Verment";
	}

}
