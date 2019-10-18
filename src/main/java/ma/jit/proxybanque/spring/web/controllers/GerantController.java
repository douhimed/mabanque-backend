package ma.jit.proxybanque.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.services.IGerantServices;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Employer;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/gerants")
public class GerantController {
	
	@Autowired
	private IGerantServices gerantServices;
	
	@GetMapping
	public List<Employer> getAgence(@RequestHeader(name="id-user") int idGerant) {
		List<Employer> employes = this.gerantServices.getEmployesByGerant(idGerant);
		System.out.println("Size : " + employes.size());
		return employes;
	}
	
}
