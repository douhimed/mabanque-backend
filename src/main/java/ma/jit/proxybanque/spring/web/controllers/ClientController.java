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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxybanque.spring.services.IConseillerServices;
import ma.jit.proxybanque.spring.services.exceptions.ServiceExceptions;
import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.tdo.DTOClient;

/**
 * 
 * <h3>ClientController</h3>
 * <p>Le point d'entrée de toutes requetes /clients</p>
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
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private IConseillerServices conseillerServices;

	@GetMapping("/{id}")
	public Client get(@PathVariable int id) {
		return this.conseillerServices.getClients(id);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestHeader(name = "id-client") int id) {
		this.conseillerServices.deleteClient(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public Client addClient(@RequestBody DTOClient tdoClient) {
		try {
			return this.conseillerServices.addClient(tdoClient.buildClient(), tdoClient.getConseillerID());
		} catch (ServiceExceptions e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping
	public Client update(@RequestBody DTOClient tdoClient) {
		return this.conseillerServices.updateClient(tdoClient.buildClient(), tdoClient.getConseillerID());

	}

}
