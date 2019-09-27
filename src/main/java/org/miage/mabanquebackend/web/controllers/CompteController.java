package org.miage.mabanquebackend.web.controllers;

import java.util.List;

import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comptes")
public class CompteController {
	
	@Autowired
	private IConseillerServices conseillerServices;
	
	
	
	@GetMapping("/{id}")
	public List<Client> getClientsByConseiller(@PathVariable int id){
		return this.conseillerServices.getClientsByConseiller(new Conseiller(id));
	}


}
