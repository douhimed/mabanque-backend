package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Employer;

/**
 * <h3>EmployeDao</h3>
 * <p>Fonctions générer par Spring Data, que les fonctions appelé dans la couche business seront générer</p>
 * <p>Les fonctions sont générées après les conventions de nommage</p>
 * <p>Exemple : </p>
 * <p>findByUsername : chercher employe par nom d'utilisateur, Spring va géréner une implementation selon les conventions</p>
 * 
 * @author proxybanque
 * @version 1.0
 */
@Repository
public interface EmployeDao extends JpaRepository<Employer, Integer> {

	Employer findByUsername(String username);
	List<Employer> findByIdResponsable(int idGerant);
}
