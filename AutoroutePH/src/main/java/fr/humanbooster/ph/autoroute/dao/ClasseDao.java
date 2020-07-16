package fr.humanbooster.ph.autoroute.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Classe;

public interface ClasseDao {

	//Méthodes CRUD 
	
	//YAGNI : You aren't gonna need it
	//KISS : Keep it stupid simple
	//DRY : Don't repeat yourself
	
	//C : create, renvoie un péage
	Classe create(Classe peage) throws SQLException;
	
	//R : read
	Classe findOne(Long id) throws SQLException;
	
	List<Classe> findAll() throws SQLException;
	
}
