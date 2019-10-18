package ma.jit.proxybanque.spring.web.models;

import java.util.Random;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private double taux = 3;

	public CompteEpargne() {
	}

	public CompteEpargne(double solde,double taux) {
		super(solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public void setCarteType(String carteType) {	
	}


}
