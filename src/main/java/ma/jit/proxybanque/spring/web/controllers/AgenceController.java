package ma.jit.proxybanque.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.services.IGerantServices;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Client;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/agences")
public class AgenceController {

	@Autowired
	private IGerantServices gerantServices;
	
	@GetMapping
	public Agence get(@RequestHeader(name = "id-user") int id) {
		return this.gerantServices.getAgenceByGerant(id);
	}
	
}
