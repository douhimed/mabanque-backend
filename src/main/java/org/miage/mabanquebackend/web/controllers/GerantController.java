package org.miage.mabanquebackend.web.controllers;

import java.util.List;

import org.miage.mabanquebackend.services.IGerantServices;
import org.miage.mabanquebackend.web.models.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/gerants")
public class GerantController {
	
	@Autowired
	private IGerantServices gerantServices;
	
	@GetMapping
	public Agence getAgence(@RequestHeader(name="id-user") int idGerant) {
		return this.gerantServices.getAgenceByGerant(idGerant);
	}
	
}
