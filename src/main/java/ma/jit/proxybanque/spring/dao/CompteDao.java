package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Compte;

/**
 * <h3>CompteDao</h3>
 * <p>Fonctions générer par Spring Data, que les fonctions appelé dans la couche business seront générer</p>
 * <p>Les fonctions sont générées après les conventions de nommage</p>
 * <p>Exemple : </p>
 * <p>findAllByClient : chercher compte par client, Spring va géréner une implementation selon les conventions</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {

	List<Compte> findAllByClient(Client client);

	Compte findByCode(String code);

	Client findByClient(int id);

}
