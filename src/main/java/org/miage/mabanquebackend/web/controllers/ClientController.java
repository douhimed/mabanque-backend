package org.miage.mabanquebackend.web.controllers;

import java.net.URI;
import java.util.List;

import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Conseiller;
import org.miage.mabanquebackend.web.models.tdo.TDOClient;
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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		this.conseillerServices.deleteClient(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public Client addClient(@RequestBody TDOClient tdoClient) {
		return this.conseillerServices.addClient(tdoClient.buildClient(), tdoClient.getConseillerID());

	}

	/*
	 * @GetMapping public List<Client> getByConseiller(@RequestHeader(name =
	 * "id-conseiller") int idConseiller) { return
	 * this.conseillerServices.getClientsByConseiller(new Conseiller(idConseiller));
	 * }
	 * 
	 * @GetMapping("/{id}") public Client get(@PathVariable int id) { return
	 * this.conseillerServices.getClients(id); }
	 * 
	 * @PutMapping public ResponseEntity<Client> update(@RequestBody Client client)
	 * { Client updatedClient = this.conseillerServices.updateClient(client); return
	 * new ResponseEntity<Client>(updatedClient, HttpStatus.OK); }
	 * 
	 * @PostMapping public ResponseEntity<Void> addClient(@RequestBody Client
	 * client) { Client createdClient = this.conseillerServices.addClient(client);
	 * URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{idClient}").
	 * buildAndExpand(createdClient.getId()) .toUri(); return
	 * ResponseEntity.created(uri).build(); }
	 * 
	 */
}
