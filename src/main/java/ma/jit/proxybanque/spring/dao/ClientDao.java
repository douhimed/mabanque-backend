package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Employer;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

	List<Client> findAllByEmploye(Employer employe);

}
