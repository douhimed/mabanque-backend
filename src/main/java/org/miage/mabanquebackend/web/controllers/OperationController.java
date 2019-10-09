package org.miage.mabanquebackend.web.controllers;

import org.miage.mabanquebackend.services.ConseillerServices;
import org.miage.mabanquebackend.services.IConseillerServices;
import org.miage.mabanquebackend.web.models.Compte;
import org.miage.mabanquebackend.web.models.tdo.DTOOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/operations")
public class OperationController {
	
	@Autowired
	private IConseillerServices conseillerServices;

	@PostMapping
	public Compte saveOperation(@RequestBody DTOOperation dtoOperation) {
		return this.conseillerServices.addOperation(dtoOperation);
	}
	
}
