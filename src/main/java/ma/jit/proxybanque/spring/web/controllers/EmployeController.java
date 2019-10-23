package ma.jit.proxybanque.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.services.IGerantServices;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;

/**
 * 
 * <h3>EmployeController</h3>
 * <p>Le point d'entrée de toutes requetes /employes</p>
 * <p>@RestController : envoyer les resultats sous format JSON par default</p>
 * <p>@PostMapping</p> : l'ajout, les requete http/post</p>
 * <p>@GetMapping : http/get </p>
 * <p>@Putmapping : la modification, http/put</p>
 * <p>@Deletemapping : la suppression, http/delete</p>
 * <p>@PathVariable : une valeur d'apres url</p>
 * <p>@RequestHeader : une valeur depuis l'entete de requete http</p>
 * <p>@RequestBody :  les données envoye par le client sont enregistrer dans le corp</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@RestController
@RequestMapping("/employes")
public class EmployeController {

	@Autowired
	private IGerantServices gerantServices;


	@GetMapping("/{id}")
	public Employer get(@PathVariable int id) {
		return this.gerantServices.getEmploye(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id, @RequestHeader(name="id-user") int idGerant) {
		this.gerantServices.deleteEmploye(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public Employer update(@RequestBody DTOEmploye tdoEmp) {
		return  this.gerantServices.updateEmploye(tdoEmp);
	}
	
	@PostMapping
	public Employer addEmploye(@RequestBody DTOEmploye tdoEmp, @RequestHeader(name="id-user") int idUser) {
		return this.gerantServices.addEmploye(tdoEmp, idUser);
	}

}
