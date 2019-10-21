package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Employer;

/**
 * <h3>ClientDao</h3>
 * <p>Fonctions générer par Spring Data, que les fonctions appelé dans la couche business seront générer</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

	List<Client> findAllByEmploye(Employer employe);

}
