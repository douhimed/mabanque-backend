package ma.jit.proxybanque.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import ma.jit.proxybanque.spring.services.IConseillerServices;
import ma.jit.proxybanque.spring.services.exceptions.ServiceExceptions;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.tdo.DTOCompte;

/**
 * 
 * <h3>CompteController</h3>
 * <p>Le point d'entrée de toutes requetes /comptes</p>
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
@CrossOrigin(origins = "*")
@RequestMapping("/comptes")
public class CompteController {

	@Autowired
	private IConseillerServices conseillerServices;

	@GetMapping("/{id}")
	public Compte get(@PathVariable int id) {
		return this.conseillerServices.getCompte(id);
	}

	@PostMapping
	public Compte addCompte(@RequestBody DTOCompte tdoCompte) throws ServiceExceptions {
		Compte compte = tdoCompte.buildCompte();
		return this.conseillerServices.addCompte(compte, tdoCompte.getClientId());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) throws ServiceExceptions {
		this.conseillerServices.deleteCompte(id);
		return ResponseEntity.noContent().build();
	}

}
