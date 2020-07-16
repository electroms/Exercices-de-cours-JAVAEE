package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.JoueurDao;
import fr.humanbooster.fx.englishbattle.dao.impl.JoueurDaoImpl;
import fr.humanbooster.fx.englishbattle.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {

	private JoueurDao joueurDao = new JoueurDaoImpl();

	public Joueur ajouterJoueur(Joueur joueur) {
		try {
			return joueurDao.create(joueur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void ajouterJoueurInitial() {

		Joueur joueur = new Joueur();
		try {
			joueurDao.create(joueur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Joueur ajouterJoueur(String nom, String prenom, String motDePasse, String email, Ville ville,
			Niveau niveau) {
		Joueur joueur = new Joueur();
		joueur.setNom(nom);
		joueur.setPrenom(prenom);
		joueur.setMotDePasse(motDePasse);
		joueur.setEmail(email);
		joueur.setVille(ville);
		joueur.setNiveau(niveau);

		try {
			joueur = joueurDao.create(joueur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return joueur;
	}

	@Override
	public Joueur recupererJoueur(Long id) {
		try {
			return joueurDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Joueur recupererJoueur(String email, String mdp) {
		try {
			return joueurDao.findOne(email, mdp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Joueur> recupererJoueurs() {
		try {
			return joueurDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Joueur majJoueur(Joueur joueur) {
		Joueur joueurTemp = new Joueur();
		joueurTemp.setId(joueur.getId());
		joueurTemp.setMotDePasse(joueur.getMotDePasse());
		try {
			return joueurDao.update(joueurTemp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerJoueur(Long id) {
		try {
			return joueurDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
