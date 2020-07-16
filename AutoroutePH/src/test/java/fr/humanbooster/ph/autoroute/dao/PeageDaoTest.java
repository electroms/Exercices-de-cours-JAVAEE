package fr.humanbooster.ph.autoroute.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.ph.autoroute.business.Peage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PeageDaoTest {

	private PeageDao peageDao = null;
	private static Peage peage = null;

	@Test
	@Order(1)
	void testCreate() {
		String nom = "TestPeageDao";

		try {
			peage = peageDao.create(new Peage("Montpelier"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(peage);
		assertTrue(peage.getId() > 0);
		assertEquals(peage.getNom(), nom);
	}

	@Test
	@Order(2)
	void testFindOne() {
		Peage peageRecuperer = null;

		try {
			peageRecuperer = peageDao.findOne(peage.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(peageRecuperer);
		assertTrue(peageRecuperer.getId() == peage.getId());
		assertEquals(peageRecuperer.getNom(), peage.getNom());
	}

	@Test
	@Order(3)
	void testFindAll() {
		List<Peage> peages = new ArrayList<>();
		try {
			peages = peageDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertFalse(peages.isEmpty());
	}

	@Test
	@Order(4)
	void testUpdate() {
		// Je n'ai pas réussi à développer cette méthode aucun exemple
		fail("Not yet implemented");
	}

	@Test
	@Order(5)
	void testDelete() {
		boolean estRetirer = false;
		try {
			estRetirer = peageDao.delete(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(estRetirer);

		try {
			peage = peageDao.findOne(peage.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(peage.getId());
	}

}
