package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.JoueurDao;
import fr.humanbooster.fx.englishbattle.dao.NiveauDao;
import fr.humanbooster.fx.englishbattle.dao.Requetes;
import fr.humanbooster.fx.englishbattle.dao.VilleDao;

public class JoueurDaoImpl implements JoueurDao {
	private Connection connexion;
	private VilleDao villeDao;
	private NiveauDao niveauDao;

	public JoueurDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			villeDao = new VilleDaoImpl();
			niveauDao = new NiveauDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Joueur create(Joueur joueur) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_JOUEUR, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, joueur.getEmail());
		ps.setString(2, joueur.getMotDePasse());
		ps.setString(3, joueur.getNom());
		ps.setString(4, joueur.getPrenom());
		ps.setLong(5, joueur.getNiveau().getId());
		ps.setLong(6, joueur.getVille().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		joueur.setId(rs.getLong(1));
		return null;
	}

	@Override
	public Joueur findOne(Long id) throws SQLException {
		Joueur joueur = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.JOUEUR_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			joueur = new Joueur();
			joueur.setId(rs.getLong("id"));
			joueur.setEmail(rs.getString("email"));
			joueur.setMotDePasse(rs.getString("email"));
			joueur.setNom(rs.getString("nom"));
			joueur.setPrenom(rs.getString("prenom"));
			joueur.setNiveau(niveauDao.findOne(rs.getLong("niveau_id")));
			joueur.setVille(villeDao.findOne(rs.getLong("ville_id")));
		}
		return joueur;
	}

	@Override
	public Joueur findOne(String mail, String mdp) throws SQLException {
		Joueur joueur = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.JOUEUR_PAR_MAIL_ET_MDP);
		ps.setString(1, mail);
		ps.setString(2, mdp);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			joueur = new Joueur();
			joueur.setId(rs.getLong("id"));
			joueur.setEmail(rs.getString("email"));
			joueur.setMotDePasse(rs.getString("email"));
			joueur.setNom(rs.getString("nom"));
			joueur.setPrenom(rs.getString("prenom"));
			joueur.setNiveau(niveauDao.findOne(rs.getLong("niveau_id")));
			joueur.setVille(villeDao.findOne(rs.getLong("ville_id")));
		}
		return joueur;
	}

	@Override
	public List<Joueur> findAll() throws SQLException {
		List<Joueur> joueurs = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_JOUEURS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			joueurs.add(findOne(rs.getLong("id")));
		}
		return joueurs;
	}

	@Override
	public Joueur update(Joueur joueur) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_JOUEUR_MOT_DE_PASSE);
		ps.setString(1, joueur.getMotDePasse());
		ps.setLong(2, joueur.getId());
		ps.executeUpdate();
		return findOne(joueur.getId());
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		Joueur joueur = findOne(id);
		boolean estEfface = false;
		if (joueur != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_JOUEUR);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}
}