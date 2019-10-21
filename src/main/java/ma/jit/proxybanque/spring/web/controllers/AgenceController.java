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

/**
 * 
 * <h3>AgenceController</h3>
 * <p>Le point d'entrée de toutes requetes /employes</p>
 * <p>@RestController : envoyer les resultats sous format JSON par default</p>
 * <p>GetMapping : la consultation, les requete http/get </p>
 *
 * @author proxybanque
 * @version 1.0
 */
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
