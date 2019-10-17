package org.miage.mabanquebackend.web.controllers;

import java.net.URI;
import java.util.List;

import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.tdo.DTOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private IConseillerServices conseillerServices;

	@GetMapping("/{id}")
	public Client get(@PathVariable int id) {
		return this.conseillerServices.getClients(id);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestHeader(name = "id-client") int id) {
		this.conseillerServices.deleteClient(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public Client addClient(@RequestBody DTOClient tdoClient) {
		return this.conseillerServices.addClient(tdoClient.buildClient(), tdoClient.getEmployeID());
	}

	@PutMapping
	public Client update(@RequestBody DTOClient tdoClient) {
		return this.conseillerServices.updateClient(tdoClient.buildClient(), tdoClient.getEmployeID());

	}

}
