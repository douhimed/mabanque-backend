package org.miage.mabanquebackend.web.controllers;

import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.tdo.DTOCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/comptes")
public class CompteController {

	@Autowired
	private IConseillerServices conseillerServices;
	
	@GetMapping("/{id}")
	public Compte get(@PathVariable int id) {
		return this.conseillerServices.getCompte(id);
	}
	
	
	@PostMapping
	public Compte addCompte(@RequestBody DTOCompte tdoCompte) {
		Compte compte = tdoCompte.buildCompte();
		return this.conseillerServices.addCompte(compte, tdoCompte.getClientId());
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		this.conseillerServices.deleteCompte(id);
		return ResponseEntity.noContent().build();
	}
	
	/*
	@GetMapping("/{id}")
	public Compte get(@PathVariable int id) {
		return this.conseillerServices.getCompte(id);
	}
	
	@PutMapping
	public ResponseEntity<Compte> update(@RequestBody Compte compte) {
		System.out.println(compte);
		Compte updatedCompte = this.conseillerServices.updateCompte(compte);
		return new ResponseEntity<Compte>(updatedCompte, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> add(@RequestBody Compte compte) {
		Compte createdCompte = this.conseillerServices.addCompte(compte);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCompte.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
*/
	
}
