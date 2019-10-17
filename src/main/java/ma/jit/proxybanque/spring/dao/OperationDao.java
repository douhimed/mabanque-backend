package ma.jit.proxybanque.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.Operation;

@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {

	List<Operation> findAllByCompte(Compte compte);

}
