package org.miage.mabanquebackend.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ma.jit.proxybanque.spring.dao.CompteDao;
import ma.jit.proxybanque.spring.dao.EmployeDao;
import ma.jit.proxybanque.spring.services.ConseillerServices;
import ma.jit.proxybanque.spring.web.models.Conseiller;
import ma.jit.proxybanque.spring.web.models.Employer;

class EmployeDaoTests {

	@Mock
	private EmployeDao employeDao;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void findById_ShouldReturnEmploye() {

		Employer expectedEmployer = new Conseiller(1);
		expectedEmployer.setNom("Hamza");

		when(employeDao.findById(1)).thenReturn(Optional.of(expectedEmployer));

		Employer actualEmployer = employeDao.findById(1).get();

		assertEquals(expectedEmployer.getId(), actualEmployer.getId());

		verify(employeDao).findById(expectedEmployer.getId());

	}

	@Test
	void findAll_ShouldReturnAllEmployer() {

		List<Employer> expectedEmployers = new ArrayList<Employer>();
		Employer emp1 = new Conseiller(1);
		emp1.setNom("Hamza");
		Employer emp2 = new Conseiller(2);
		emp2.setNom("mouna");
		expectedEmployers.add(emp1);
		expectedEmployers.add(emp2);

		when(employeDao.findAll()).thenReturn(expectedEmployers);

		List<Employer> actualEmployers = employeDao.findAll();

		assertEquals(expectedEmployers.size(), actualEmployers.size());
		for (int i = 0; i < expectedEmployers.size(); i++) {
			assertEquals(expectedEmployers.get(i).getId(), actualEmployers.get(i).getId());
			assertEquals(expectedEmployers.get(i).getNom(), actualEmployers.get(i).getNom());

		}

		verify(employeDao).findAll();

	}

}
