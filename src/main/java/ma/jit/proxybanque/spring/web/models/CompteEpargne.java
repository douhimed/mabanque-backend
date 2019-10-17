package ma.jit.proxybanque.spring.web.models;

import java.util.Random;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private double taux;

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
	public String toString() {
		return "CompteEpargne [taux=" + taux + ", toString()=" + super.toString() + "]";
	}
	
	private String generateCode(int lingth) {
		int m = (int) Math.pow(10, lingth - 1);
		return String.valueOf(m + new Random().nextInt(9 * m));
	}


}
