package org.miage.mabanquebackend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ma.jit.proxybanque.spring.dao.ClientDao;
import ma.jit.proxybanque.spring.dao.CompteDao;
import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.services.ConseillerServices;
import ma.jit.proxybanque.spring.services.GerantServices;
import ma.jit.proxybanque.spring.services.exceptions.ServiceExceptions;
import ma.jit.proxybanque.spring.web.models.Agence;
import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.CompteCourant;
import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.Gerant;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

class GerantServicesTests {

	@Mock
	private ClientDao clientDao;

	@Mock
	private EmployeDao employeDao;

	@Mock
	private CompteDao compteDao;

	@InjectMocks
	private GerantServices services;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addClient_ShouldThrowexception() {
		assertThrows(ServiceExceptions.class, () -> services.addClient(new Client(), 1));
	}

	@Test
	public void addOPeration_ShouldReturnException() {
		Throwable exception = assertThrows(ServiceExceptions.class, () -> services.addOperation(new DTOOperation()));
		assertEquals(exception.getMessage(), "Not Allowed");
	}

	@Test
	public void addCompte_ShouldReturnException() {
		Throwable exception = assertThrows(ServiceExceptions.class, () -> services.addCompte(new CompteCourant(), 1));
		assertEquals(exception.getMessage(), "Not Allowed");
	}

	@Test
	public void deleteCompte_ShouldReturnException() {
		Throwable exception = assertThrows(ServiceExceptions.class, () -> services.deleteCompte(1));
		assertEquals(exception.getMessage(), "Not Allowed");
	}

	@Test
	public void getEmployesByGerant_ShouldReturnEmployesOfGerant() {

		Employer gerant = new Gerant(1);

		List<Employer> conseillers = new ArrayList<Employer>();
		conseillers.add(new Conseiller(1));
		conseillers.add(new Conseiller(2));
		conseillers.add(new Conseiller(3));

		when(employeDao.findByIdResponsable(gerant.getId())).thenReturn(conseillers);

		List<Employer> actualConseillers = services.getEmployesByGerant(gerant.getId());

		assertEquals(conseillers.size(), actualConseillers.size());

		for (int i = 0; i < conseillers.size(); i++) {
			assertEquals(conseillers.get(i).getId(), actualConseillers.get(i).getId());
		}

		verify(employeDao).findByIdResponsable(gerant.getId());

	}
	
	@Test
	public void getAgenceByGerant_ShouldReturnAgence() {

		Employer gerant = new Gerant(1);
		
		Agence expectedAgence = new Agence(1);
		expectedAgence.setName("Sallama");
		gerant.setAgence(expectedAgence);
		
		when(employeDao.findById(gerant.getId())).thenReturn(Optional.of(gerant));
		
		Agence actualAgence = services.getAgenceByGerant(gerant.getId());
		assertEquals(expectedAgence.getId(), actualAgence.getId());
		assertEquals(expectedAgence.getName(), actualAgence.getName());
		
		verify(employeDao).findById(gerant.getId());
		
		
	}
	

}
