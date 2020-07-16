package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.JoueurDao;
import fr.humanbooster.fx.englishbattle.dao.PartieDao;
import fr.humanbooster.fx.englishbattle.dao.Requetes;

public class PartieDaoImpl implements PartieDao {

	private static Connection connection;
	private static JoueurDao joueurDao;

	public PartieDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
			joueurDao = new JoueurDaoImpl();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Partie create(Partie partie) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_PARTIE, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, partie.getJoueur().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		partie.setId(rs.getLong(1));
		return partie;
	}

	@Override
	public List<Partie> findAll() throws SQLException {
		List<Partie> parties = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(Requetes.TOUTES_LES_PARTIES);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Joueur joueurTemp = joueurDao.findOne(rs.getLong("Joueur_id"));
			Partie partie = new Partie();
			partie.setId(rs.getLong("id"));
			partie.setJoueur(joueurTemp);
			parties.add(partie);
		}
		return parties;
	}

	/**
	 * Cette méthode renvoie la partie ayant l'id donné en paramètre
	 * 
	 * @param l'id de la partie recherché
	 * @return un objet de type partie, null sur la partie n'est pas trouvée
	 */

	@Override
	public Partie findOne(Long id) throws SQLException {
		Partie partie = null;
		PreparedStatement ps = connection.prepareStatement(Requetes.PARTIE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		// next se place sur la première ligne de résultat, si trouve pas de résultat,
		// il renvoie null
		if (rs.next()) {
			// On crée la partie avec un joueur
			partie = new Partie(joueurDao.findOne(rs.getLong("Joueur_id")));
			// On alimente cette partie avec un id
			partie.setId(rs.getLong("id"));
		}
		return partie;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		if (findOne(id) == null)
			return false;
		PreparedStatement ps = connection.prepareStatement(Requetes.SUPPRESSION_PARTIE);
		ps.setLong(1, id);
		ps.executeUpdate();
		return true;
	}

}
