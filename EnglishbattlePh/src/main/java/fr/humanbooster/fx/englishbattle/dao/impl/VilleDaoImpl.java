package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.Requetes;
import fr.humanbooster.fx.englishbattle.dao.VilleDao;

public class VilleDaoImpl implements VilleDao {

	private Connection connexion;
	
	public VilleDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Ville create(Ville ville) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_VILLE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, ville.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		ville.setId(rs.getLong(1));
		return ville;
	}

	@Override
	public Ville findOne(Long id) throws SQLException {
		Ville ville = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.VILLE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ville = new Ville(rs.getString("nom"));
			ville.setId(rs.getLong("id"));
		}
		return ville;
	}

	@Override
	public List<Ville> findAll() throws SQLException {
		List<Ville> villes = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_VILLES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Ville ville = new Ville(rs.getString("nom"));
			ville.setId(rs.getLong("id"));
			villes.add(ville);
		}
		return villes;
	}

	@Override
	public Ville update(Ville ville) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.MODIFICATION_VILLE);
		ps.setString(1, ville.getNom());
		ps.setLong(2, ville.getId());
		ps.executeUpdate();	
		return ville;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		if (findOne(id)==null) return false;
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_VILLE);
		ps.setLong(1, id);
		ps.executeUpdate();			
		return true;
	}

}
