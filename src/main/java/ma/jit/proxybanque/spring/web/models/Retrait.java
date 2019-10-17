package ma.jit.proxybanque.spring.web.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

	public Retrait() {
		super();
	}

	public Retrait(double montant) {
		super(montant);
	}

	public Retrait(double montant, Compte compte) {
		super(montant, compte);
	}

	public Retrait(int id, Date dateOperation, double montant, Compte compte) {
		super(id, dateOperation, montant, compte);
	}

	@Override
	public void setType() {
		this.type = "Retrait";
	}

}
