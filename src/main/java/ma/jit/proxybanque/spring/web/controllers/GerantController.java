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

/**
 * 
 * <h3>GerantController</h3>
 * <p>
 * Le point d'entrée de toutes requetes /gerants
 * </p>
 * <p>
 * @RestController : envoyer les resultats sous format JSON par default
 * </p>
 * <p>
 * @GetMapping : http/get
 * </p>
 * <p>
 * @RequestHeader : une valeur depuis l'entete de requete http
 * </p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gerants")
public class GerantController {

	@Autowired
	private IGerantServices gerantServices;

	@GetMapping
	public List<Employer> getAgence(@RequestHeader(name = "id-user") int idGerant) {
		return this.gerantServices.getEmployesByGerant(idGerant);
	}

}
