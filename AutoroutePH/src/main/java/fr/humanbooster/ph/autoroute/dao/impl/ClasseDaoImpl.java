package fr.humanbooster.ph.autoroute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Classe;
import fr.humanbooster.ph.autoroute.dao.ClasseDao;
import fr.humanbooster.ph.autoroute.dao.ConnexionBdd;
import fr.humanbooster.ph.autoroute.dao.Requetes;

public class ClasseDaoImpl implements ClasseDao {

	//La DAO a besoin d'une connexion à la base
	private Connection connexion;
	
	public ClasseDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Classe create(Classe classe) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_CLASSE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, classe.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		classe.setId(rs.getLong(1));
		return classe;
	}

	@Override
	public Classe findOne(Long id) throws SQLException {
		Classe classe = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.CLASSE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			classe = new Classe(rs.getString("nom"));
			classe.setId(rs.getLong("id"));
		}
		return classe;
	}

	@Override
	public List<Classe> findAll() throws SQLException { 
		List<Classe> peages = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_CLASSES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Classe peage = new Classe(rs.getString("nom"));
			peage.setId(rs.getLong("id"));
			peages.add(peage);
		}
		return peages;
	}

	protected void finalize() throws Throwable {
		connexion.close();
	}
}
