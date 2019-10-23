package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.Operation;

/**
 * <h3>OperationDao</h3>
 * <p>Fonctions générer par Spring Data, que les fonctions appelé dans la couche business seront générer</p>
 * <p>Les fonctions sont générées après les conventions de nommage</p>
 * <p>Exemple : </p>
 * <p>findAllByCompte : chercher les opérations par compte, Spring va géréner une implementation selon les conventions</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {

	List<Operation> findAllByCompte(Compte compte);

}
