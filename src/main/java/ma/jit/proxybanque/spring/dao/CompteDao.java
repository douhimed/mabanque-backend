package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {

	List<Compte> findAllByClient(Client client);

	Compte findByCode(String code);

}
