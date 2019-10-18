package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Employer;

@Repository
public interface EmployeDao extends JpaRepository<Employer, Integer> {

	Employer findByUsername(String username);
	List<Employer> findByIdResponsable(int idGerant);
}
