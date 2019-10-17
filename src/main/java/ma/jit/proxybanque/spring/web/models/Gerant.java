package ma.jit.proxybanque.spring.web.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("G")
public class Gerant extends Employe {

	public Gerant() {
		super();
	}

	public Gerant(int id) {
		super(id);
	}

	public Gerant(int id, String nom, String prenom, String username, String password, String email, String adresse) {
		super(id, nom, prenom, username, password, email, adresse);
	}

	public Gerant(String nom, String prenom, String username, String password, String email, String adresse) {
		super(nom, prenom, username, password, email, adresse);
	}

	@Override
	public void setType() {
		this.type = "gerant";
	}

}
