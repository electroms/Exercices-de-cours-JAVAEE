package fr.humanbooster.fx.docteurhb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Patient;
import fr.humanbooster.fx.docteurhb.dao.ConnexionBdd;
import fr.humanbooster.fx.docteurhb.dao.PatientDao;
import fr.humanbooster.fx.docteurhb.dao.Requetes;

public class PatientDaoImpl implements PatientDao {

	private Connection connexion;

	public PatientDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Patient create(Patient patient) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_PATIENT, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, patient.getId());
		ps.setDate(2, (Date) patient.getDateDeNaissance());
		ps.setString(3, patient.getNom());
		ps.setString(4, patient.getPrenom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		patient.setId(rs.getLong(1));
		return null;
	}

	public Patient findOne(Long id, Date dateDeNaissance, String nom, String prenom) throws SQLException {
		Patient patient = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.PATIENT_PAR_ID_ET_NOM);
		ps.setLong(1, id);
		ps.setString(2, nom);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			patient = new Patient();
			patient.setId(rs.getLong("id"));
			patient.setDateDeNaissance(rs.getDate("date"));
			patient.setNom(rs.getString("nom"));
			patient.setPrenom(rs.getString("prenom"));
		}
		return patient;
	}

	@Override
	public List<Patient> findAll() throws SQLException {
		List<Patient> patients = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_PATIENTS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			patients.add(findOne(rs.getLong("id"), rs.getDate("date"), rs.getString("nom"), rs.getString("prenom")));
		}
		return patients;
	}

	@Override
	public Patient update(Patient patient) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_PATIENT);
		ps.setString(1, patient.getNom());
		ps.setLong(2, patient.getId());
		ps.executeUpdate();
		return findOne(patient.getId(), (Date) patient.getDateDeNaissance(), patient.getNom(), patient.getPrenom());
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		Patient patient = findOne(id, null, null, null);
		boolean estEfface = false;
		if (patient != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_PATIENT);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}

}
