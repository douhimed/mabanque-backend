package org.miage.mabanquebackend.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ma.jit.proxybanque.spring.dao.ClientDao;
import ma.jit.proxybanque.spring.dao.CompteDao;
import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.services.ConseillerServices;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.CompteCourant;
import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.Gerant;

public class ConseillerServicesTests {

	@Mock
	private ClientDao clientDao;

	@Mock
	private EmployeDao employeDao;

	@Mock
	private CompteDao compteDao;

	@InjectMocks
	private ConseillerServices services;

	@Before
	public void setUpBeforeeach() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getClients_ShouldReturnClients() {

		Client expectedClient = new Client(1);

		when(clientDao.findById(1)).thenReturn(Optional.of(expectedClient));

		Client actualClient = services.getClients(1);
		assertEquals(expectedClient.getId(), actualClient.getId());
		verify(clientDao).findById(expectedClient.getId());

	}

	@Test
	public void updateClient_ShouldReturnUpdatedClient() {

		Client expectedClient = new Client(1);
		Employer expectedEmployer = new Conseiller(1);

		when(employeDao.findById(1)).thenReturn(Optional.of(expectedEmployer));
		when(clientDao.save(expectedClient)).thenReturn(expectedClient);

		Client actualClient = services.updateClient(expectedClient, expectedEmployer.getId());
		assertEquals(expectedClient.getId(), actualClient.getId());

		verify(employeDao).findById(expectedEmployer.getId());
		verify(clientDao).save(expectedClient);

	}

	@Test
	public void getCompte_ShouldReturnCompte() {

		Compte expectedCompte = new CompteCourant();
		expectedCompte.setId(1);

		when(compteDao.findById(expectedCompte.getId())).thenReturn(Optional.of(expectedCompte));

		Compte actualCompte = services.getCompte(1);
		assertEquals(expectedCompte.getId(), actualCompte.getId());

		verify(compteDao).findById(expectedCompte.getId());

	}

	@Test
	public void addCompte_ShouldReturnNewAddedCompte() {

		Compte expectedCompte = new CompteCourant();
		expectedCompte.setId(1);
		int clientId = 1;

		Client expectedClient = new Client(1);

		when(clientDao.findById(1)).thenReturn(Optional.of(expectedClient));
		when(compteDao.save(expectedCompte)).thenReturn(expectedCompte);

		Compte actualCompte = services.addCompte(expectedCompte, clientId);
		assertEquals(expectedCompte.getId(), actualCompte.getId());

		verify(clientDao).findById(expectedClient.getId());
		verify(compteDao).save(expectedCompte);

	}

	@Test
	public void getEmployer_ShouldReturnEmployer() {

		Employer expectedEmployer = new Conseiller(1);
		expectedEmployer.setNom("Ahmed");
		expectedEmployer.setIdResponsable(1);

		when(employeDao.findById(expectedEmployer.getId())).thenReturn(Optional.of(expectedEmployer));

		Employer actualEmployer = services.getEmploye(expectedEmployer.getId());
		assertEquals(expectedEmployer.getId(), actualEmployer.getId());
		assertEquals(expectedEmployer.getNom(), actualEmployer.getNom());
		assertEquals(expectedEmployer.getIdResponsable(), actualEmployer.getIdResponsable());

		verify(employeDao).findById(expectedEmployer.getId());

	}
	

}
