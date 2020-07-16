package fr.humanbooster.fx.docteurhb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;
import fr.humanbooster.fx.docteurhb.dao.ConnexionBdd;
import fr.humanbooster.fx.docteurhb.dao.ParametreDao;
import fr.humanbooster.fx.docteurhb.dao.PatientDao;
import fr.humanbooster.fx.docteurhb.dao.ReleveDao;
import fr.humanbooster.fx.docteurhb.dao.Requetes;

public class ParametreDaoImpl implements ParametreDao {

	private Connection connexion;
	private PatientDao patientDao;
	private ReleveDao releveDao;

	public ParametreDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			patientDao = new PatientDaoImpl();
			releveDao = new ReleveDaoImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Parametre create(Parametre parametre) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_PARAMETRE, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, parametre.getId());
		ps.setString(2, parametre.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return null;
	}

	@Override
	public Parametre findOne(Long id, String nom) throws SQLException {
		Parametre parametre = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.PARAMETRE_PAR_ID_ET_NOM);
		ps.setLong(1, id);
		ps.setString(2, nom);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			parametre = new Parametre();
			parametre.setId(rs.getLong("id"));
			parametre.setNom(rs.getString("nom"));
		}
		return parametre;
	}

	@Override
	public List<Parametre> findAll() throws SQLException {
		List<Parametre> parametres = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_PARAMETRES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			parametres.add(findOne(rs.getLong("id"), rs.getString("nom")));
		}
		return parametres;
	}

	@Override
	public Parametre update(Parametre parametre) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_PARAMETRE);
		ps.setString(1, parametre.getNom());
		ps.setLong(2, parametre.getId());
		ps.executeUpdate();
		return findOne(parametre.getId(), parametre.getNom());
	}

	@Override
	public boolean delete(Long id, String nom) throws SQLException {
		Parametre parametre = findOne(id, nom);
		boolean estEfface = false;
		if (parametre != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_PARAMETRE);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}

}
