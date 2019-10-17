package ma.jit.proxybanque.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxybanque.spring.dao.AgenceDao;
import ma.jit.proxybanque.spring.dao.CompteDao;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.CompteEpargne;

@Service
@Transactional
public class ParamDashboard implements IParamDashboard {

	@Autowired
	private CompteDao compteDao;
	
	@Autowired
	private AgenceDao agenceDao;
	
	@Override
	public Agence addAgance(Agence agence) {
		Compte compte = new CompteEpargne(0, 0);
		compte.setAgence(agence);
		this.compteDao.save(compte);
		agence.setCompte(compte);
		return this.agenceDao.save(agence);
	}

}
