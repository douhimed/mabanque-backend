package ma.jit.proxybanque.spring.web.controllers;

import java.net.URI;

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

import ma.jit.proxybanque.spring.services.IConseillerServices;
import ma.jit.proxybanque.spring.services.IGerantServices;
import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Employe;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;

@RestController
@RequestMapping("/employes")
public class EmployeController {

	@Autowired
	private IGerantServices gerantServices;


	@GetMapping("/{id}")
	public Employe get(@PathVariable int id) {
		return this.gerantServices.getEmploye(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		this.gerantServices.deleteEmploye(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public Employe update(@RequestBody DTOEmploye tdoEmp) {
		return  this.gerantServices.updateEmploye(tdoEmp);
	}
	
	@PostMapping
	public Employe addEmploye(@RequestBody DTOEmploye tdoEmp, @RequestHeader(name="id-user") int idUser) {
		return this.gerantServices.addEmploye(tdoEmp, idUser);
	}

}
