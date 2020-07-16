package fr.humanbooster.fx.docteurhb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;
import fr.humanbooster.fx.docteurhb.business.Patient;
import fr.humanbooster.fx.docteurhb.business.Releve;
import fr.humanbooster.fx.docteurhb.dao.ConnexionBdd;
import fr.humanbooster.fx.docteurhb.dao.ReleveDao;
import fr.humanbooster.fx.docteurhb.dao.Requetes;

public class ReleveDaoImpl implements ReleveDao {

	private Connection connexion;

	public ReleveDaoImpl() {
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
	public Releve create(Releve releve) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_RELEVE, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, releve.getId());
		ps.setDate(2, (Date) releve.getDateEnvoi());
		ps.setObject(3, releve.getPatient());
		ps.setObject(4, releve.getParametre());
		ps.setFloat(5, releve.getValeur());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		releve.setId(rs.getLong(1));
		return null;
	}

	@Override
	public Releve findOne(Long id, Date dateEnvoi, Object object, Object object2, Float valeur) throws SQLException {
		Releve releve = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.RELEVE_PAR_ID_ET_PATIENT);
		ps.setLong(1, id);
		ps.setObject(2, releve);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			releve = new Releve();
			releve.setId(rs.getLong("id"));
			releve.setDateEnvoi(rs.getDate("date"));
			releve.setPatient((Patient) rs.getObject("patient"));
			releve.setParametre((Parametre) rs.getObject("parametre"));
			releve.setValeur(rs.getFloat("valeur"));
		}
		return releve;
	}

	@Override
	public List<Releve> findAll() throws SQLException {
		List<Releve> releves = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_RELEVES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			releves.add(findOne(rs.getLong("id"), rs.getDate("date"), rs.getObject("patient"),
					rs.getObject("parametre"), rs.getFloat("valeur")));
		}
		return releves;
	}

	@Override
	public Releve update(Releve releve) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_RELEVE);
		ps.setObject(1, releve.getPatient());
		ps.setLong(2, releve.getId());
		ps.executeUpdate();
		return findOne(releve.getId(), (Date) releve.getDateEnvoi(), releve.getPatient(), releve.getParametre(),
				releve.getValeur());
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		Releve releve = null;
		Releve r = findOne(id, null, releve, releve, null);
		boolean estEfface = false;
		if (r != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_RELEVE);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}

}
