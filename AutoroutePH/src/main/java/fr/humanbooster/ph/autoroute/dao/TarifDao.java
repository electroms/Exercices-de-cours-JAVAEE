package fr.humanbooster.ph.autoroute.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Tarif;

public interface TarifDao {

	// Méthodes CRUD

	// YAGNI : You aren't gonna need it
	// KISS : Keep it stupid simple
	// DRY : Don't repeat yourself

	// C : create, renvoie un péage
	Tarif create(Tarif peage) throws SQLException;

	// R : read
	Tarif findOne(Long id) throws SQLException;

	List<Tarif> findAll() throws SQLException;

	List<Tarif> findAllByIdPeageDepart(Long idPeage) throws SQLException;

	// U : update
	Tarif update(Tarif peage) throws SQLException;

	// D : delete
	boolean delete(Long id) throws SQLException;

}
