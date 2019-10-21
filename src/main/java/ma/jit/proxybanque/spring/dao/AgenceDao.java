package ma.jit.proxybanque.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Gerant;


/**
 * <h3>AgenceDao</h3>
 * <p>Fonctions générer par Spring Data, que les fonctions appelé dans la couche business seront générer</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@Repository
public interface AgenceDao extends JpaRepository<Agence, Integer> {
}
