package org.miage.mabanquebackend.web.controllers;

import java.util.List;

import org.miage.mabanquebackend.services.IGerantServices;
import org.miage.mabanquebackend.web.models.Agence;
import org.miage.mabanquebackend.web.models.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/agences")
public class AgenceController {

	@Autowired
	private IGerantServices gerantServices;

	
}
