package org.miage.mabanquebackend.web.models.jwt;

import java.io.Serializable;

import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.Gerant;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private int idUser;
	private boolean isGerant = false;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public JwtResponse(String token, Employe user) {
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