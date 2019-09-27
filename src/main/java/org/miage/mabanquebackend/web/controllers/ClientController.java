package org.miage.mabanquebackend.web.controllers;


import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private IConseillerServices conseillerServices;

	@GetMapping("/{id}")
	public Client getClientById(@PathVariable int id) {
		return conseillerServices.getClient(id);
	}
	
}
