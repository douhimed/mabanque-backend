package ma.jit.proxybanque.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.services.ConseillerServices;
import ma.jit.proxybanque.spring.services.IConseillerServices;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

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
