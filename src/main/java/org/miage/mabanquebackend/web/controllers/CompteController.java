package org.miage.mabanquebackend.web.controllers;

import java.net.URI;

import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.CompteCourant;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		this.conseillerServices.deleteCompte(id);
		return ResponseEntity.noContent().build();
	}*/
	
}
