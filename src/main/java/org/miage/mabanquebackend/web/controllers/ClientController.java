package org.miage.mabanquebackend.web.controllers;

import java.util.List;

import org.miage.mabanquebackend.services.IClientServices;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private IClientServices clientServices;

	@GetMapping("/{id}")
	public List<Compte> getComptes(@PathVariable int id) {
		return clientServices.getComptesByClient(new Client(id));
	}
	
}
