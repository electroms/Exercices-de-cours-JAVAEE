package fr.humanbooster.fx.docteurhb.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;

public interface ParametreDao {

	Parametre create(Parametre parametre) throws SQLException;

	List<Parametre> findAll() throws SQLException;

	Parametre update(Parametre parametre) throws SQLException;

	boolean delete(Long id, String nom) throws SQLException;

	Parametre findOne(Long id, String nom) throws SQLException;

}
