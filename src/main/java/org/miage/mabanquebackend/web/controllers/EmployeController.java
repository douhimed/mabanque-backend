package org.miage.mabanquebackend.web.controllers;

import java.net.URI;

import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.services.IGerantServices;
import org.miage.mabanquebackend.web.models.Client;
import org.miage.mabanquebackend.web.models.Employe;
import org.miage.mabanquebackend.web.models.tdo.DTOEmploye;
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
@RequestMapping("/employes")
public class EmployeController {

	@Autowired
	private IGerantServices gerantServices;

	@Autowired
	private IConseillerServices conseillerServices;

	@GetMapping("/{id}")
	public Employe get(@PathVariable int id) {
		return this.conseillerServices.getConseiller(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		this.gerantServices.deleteEmploye(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Employe> update(@RequestBody DTOEmploye tdoEmp) {
		Employe employe = this.conseillerServices.updateEmploye(tdoEmp);
		return new ResponseEntity<Employe>(employe, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmploye(@RequestBody DTOEmploye tdoEmp, @RequestHeader(name="id-user") int idUser) {
		Employe employe = this.gerantServices.addEmploye(tdoEmp, idUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employe.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
