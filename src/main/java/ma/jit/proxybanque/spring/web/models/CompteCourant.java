package ma.jit.proxybanque.spring.web.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private double decouvert;
	private String carteType;

	public CompteCourant() {
	}

	public CompteCourant(double solde, double decouvert) {
		super(solde);
		this.decouvert = decouvert;
	}

	public CompteCourant(double solde, double decouvert, String carteType) {
		this(solde, decouvert);
		this.carteType = carteType;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public void setCarteType(String carteType) {
		this.carteType = carteType;
	}

	public String getCarteType() {
		return carteType;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", toString()=" + super.toString() + "]";
	}

}
