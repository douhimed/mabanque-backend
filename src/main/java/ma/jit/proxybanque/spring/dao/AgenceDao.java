package ma.jit.proxybanque.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Gerant;

@Repository
public interface AgenceDao extends JpaRepository<Agence, Integer> {

}
