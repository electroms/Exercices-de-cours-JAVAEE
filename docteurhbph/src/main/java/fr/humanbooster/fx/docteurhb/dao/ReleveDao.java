package fr.humanbooster.fx.docteurhb.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Releve;

public interface ReleveDao {

	Releve create(Releve releve) throws SQLException;

	List<Releve> findAll() throws SQLException;

	Releve update(Releve releve) throws SQLException;

	boolean delete(Long id) throws SQLException;

	Releve findOne(Long id, Date dateEnvoi, Object object, Object object2, Float valeur) throws SQLException;

}
