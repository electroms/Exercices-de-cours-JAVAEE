package fr.humanbooster.ph.autoroute.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Peage;

public interface PeageDao {

	//Méthodes CRUD 
	
	//YAGNI : You aren't gonna need it
	//KISS : Keep it stupid simple
	//DRY : Don't repeat yourself
	
	//C : create, renvoie un péage
	Peage create(Peage peage) throws SQLException;
	
	//R : read
	Peage findOne(Long id) throws SQLException;
	
	List<Peage> findAll() throws SQLException;

	//U : update
	Peage update(Peage peage) throws SQLException;
	
	//D : delete
	boolean delete(Long id) throws SQLException;

	
}
