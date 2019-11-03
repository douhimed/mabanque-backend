package ma.jit.proxybanque.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.services.IConseillerServices;
import ma.jit.proxybanque.spring.services.exceptions.ServiceExceptions;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

/**
 * 
 * <h3>OperationController</h3>
 * <p>Le point d'entrée de toutes requetes /operations</p>
 * <p>@RestController : envoyer les resultats sous format JSON par default</p>
 * <p>@PostMapping</p> : l'ajout, les requete http/post</p>
 * <p>@RequestBody :  les données envoye par le client sont enregistrer dans le corp</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/operations")
public class OperationController {
	
	@Autowired
	private IConseillerServices conseillerServices;

	@PostMapping
	public Compte saveOperation(@RequestBody DTOOperation dtoOperation) throws ServiceExceptions {
		return this.conseillerServices.addOperation(dtoOperation);
	}
	
}
