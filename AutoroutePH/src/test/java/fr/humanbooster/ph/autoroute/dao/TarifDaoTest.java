package fr.humanbooster.ph.autoroute.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.ph.autoroute.business.Classe;
import fr.humanbooster.ph.autoroute.business.Peage;
import fr.humanbooster.ph.autoroute.business.Tarif;
import fr.humanbooster.ph.autoroute.dao.impl.TarifDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TarifDaoTest {

	private TarifDao tarifDao = null;
	private static Tarif tarif = null;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeEach
	void setUp() throws Exception {
		tarifDao = new TarifDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		ConnexionBdd.close();
	}

	@Test
	@Order(1)
	void testCreate() {
		Float montant = 1f;
		Date dateEffet = new Date();
		Classe classe_id = new Classe();
		Peage peage_entree_id = new Peage();
		Peage peage_sortie_id = new Peage();

		try {
			tarif = tarifDao.create(new Tarif(montant, dateEffet, classe_id, peage_entree_id, peage_sortie_id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(tarif);
		assertTrue(tarif.getId() > 0);
		assertEquals(tarif.getMontant(), montant);
		assertEquals(tarif.getDateEffet(), dateEffet);
		assertEquals(tarif.getClasse(), classe_id);
		assertEquals(tarif.getPeageEntree(), peage_entree_id);
		assertEquals(tarif.getPeageSortie(), peage_sortie_id);
	}

	@Test
	@Order(2)
	void testFindOne() {
		Tarif tarifRecuperer = null;

		try {
			tarifRecuperer = tarifDao.findOne(tarif.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(tarifRecuperer);
		assertTrue(tarifRecuperer.getId() == tarif.getId());
		assertEquals(tarifRecuperer.getMontant(), tarif.getMontant());
		assertEquals(simpleDateFormat.format((tarifRecuperer.getDateEffet())),
				simpleDateFormat.format(tarif.getDateEffet()));
		assertEquals(tarifRecuperer.getClasse(), tarif.getClasse());
		assertEquals(tarifRecuperer.getPeageEntree(), tarif.getPeageEntree());
		assertEquals(tarifRecuperer.getPeageSortie(), tarif.getPeageSortie());

	}

	@Test
	@Order(3)
	void testFindAll() {
		List<Tarif> tarifs = new ArrayList<>();
		try {
			tarifs = tarifDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertFalse(tarifs.isEmpty());
	}

	@Test
	@Order(4)
	void testFindAllByIdPeageDepart() {
		// Je n'ai pas réussi à développer cette méthode aucun exemple
		fail("Not yet implemented");
	}

	@Test
	@Order(5)
	void testUpdate() {
		// Je n'ai pas réussi à développer cette méthode aucun exemple
		fail("Not yet implemented");
	}

	@Test
	@Order(6)
	void testDelete() {
		boolean estRetirer = false;
		try {
			estRetirer = tarifDao.delete(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(estRetirer);

		try {
			tarif = tarifDao.findOne(tarif.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// On vérifie que le stagiaire n'a plus de groupe
		assertNull(tarif.getId());
	}

}
