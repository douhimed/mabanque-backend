package ma.jit.proxybanque.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Integer> {

	Employe findByUsername(String username);
}
