package ma.jit.proxybanque.spring.web.models.jwt;

import java.io.Serializable;

import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.Gerant;

/**
 * <h3>JwtResponse</h3>
 * <p>une classe qui represente les données crypter dans le jeton envoyer par le service</p>
 * <p>le nom d'utilisateur et le mot de passe seront crypter</p>
 * 
 * @author MED DOUHI
 * @version 1.0
 */
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private int idUser;
	private boolean isGerant = false;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public JwtResponse(String token, Employer user) {
		this.jwttoken = token;
		this.idUser = user.getId();
		if (user instanceof Gerant)
			this.isGerant = true;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public int getIdUser() {
		return idUser;
	}

	public boolean isGerant() {
		return isGerant;
	}
}