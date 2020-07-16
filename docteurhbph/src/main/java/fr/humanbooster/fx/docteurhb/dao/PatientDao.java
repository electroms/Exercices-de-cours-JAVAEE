package fr.humanbooster.fx.docteurhb.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Patient;

public interface PatientDao {

	Patient create(Patient patient) throws SQLException;

	List<Patient> findAll() throws SQLException;

	Patient update(Patient patient) throws SQLException;

	boolean delete(Long id) throws SQLException;

	Patient findOne(Long id, Date dateDeNaissance, String nom, String prenom) throws SQLException;

}
