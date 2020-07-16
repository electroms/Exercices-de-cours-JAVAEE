package fr.humanbooster.ph.autoroute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Peage;
import fr.humanbooster.ph.autoroute.dao.ConnexionBdd;
import fr.humanbooster.ph.autoroute.dao.PeageDao;
import fr.humanbooster.ph.autoroute.dao.Requetes;

public class PeageDaoImpl implements PeageDao {

	//La DAO a besoin d'une connexion à la base
	private Connection connexion;
	
	public PeageDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Peage create(Peage peage) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_PEAGE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, peage.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		peage.setId(rs.getLong(1));
		return peage;
	}

	@Override
	public Peage findOne(Long id) throws SQLException {
		Peage peage = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.PEAGE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			peage = new Peage(rs.getString("nom"));
			peage.setId(rs.getLong("id"));
		}
		return peage;
	}

	@Override
	public List<Peage> findAll() throws SQLException { 
		List<Peage> peages = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_PEAGES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Peage peage = new Peage(rs.getString("nom"));
			peage.setId(rs.getLong("id"));
			peages.add(peage);
		}
		return peages;
	}
	
	@Override
	public Peage update(Peage peage) throws SQLException{
		PreparedStatement ps = connexion.prepareStatement(Requetes.MAJ_PEAGE);
		ps.setString(1, peage.getNom());
		
		ps.setLong(2, peage.getId());
		ps.executeUpdate();	
		return peage;
	}
	
	@Override
	public boolean delete(Long id) throws SQLException {
		if (findOne(id)==null) return false;
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_PEAGE);
		ps.setLong(1, id);
		ps.executeUpdate();			
		return true;
	}

	protected void finalize() throws Throwable {
		connexion.close();
	}
}
