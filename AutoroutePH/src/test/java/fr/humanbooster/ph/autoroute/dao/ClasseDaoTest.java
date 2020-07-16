package fr.humanbooster.ph.autoroute.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.ph.autoroute.business.Classe;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClasseDaoTest {

	private ClasseDao classeDao = null;
	private static Classe classe = null;

	@Test
	@Order(1)
	void testCreate() {
		String nom = "TestClasseDao";

		try {
			classe = classeDao.create(new Classe("Classe 1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(classe);
		assertTrue(classe.getId() > 0);
		assertEquals(classe.getNom(), nom);
	}

	@Test
	@Order(2)
	void testFindOne() {
		Classe classeRecuperer = null;

		try {
			classeRecuperer = classeDao.findOne(classe.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(classeRecuperer);
		assertTrue(classeRecuperer.getId() == classe.getId());
		assertEquals(classeRecuperer.getNom(), classe.getNom());
	}

	@Test
	@Order(3)
	void testFindAll() {
		List<Classe> classes = new ArrayList<>();
		try {
			classes = classeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertFalse(classes.isEmpty());
	}

}
