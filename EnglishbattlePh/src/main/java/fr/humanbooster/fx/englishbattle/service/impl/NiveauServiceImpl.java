package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.dao.NiveauDao;
import fr.humanbooster.fx.englishbattle.dao.impl.NiveauDaoImpl;
import fr.humanbooster.fx.englishbattle.service.NiveauService;

public class NiveauServiceImpl implements NiveauService {

	private NiveauDao niveauDao;

	public NiveauServiceImpl() {
		niveauDao = new NiveauDaoImpl();
	}

	@Override
	public Niveau ajouterNiveau(String nom) {
		Niveau niveau = new Niveau();
		niveau.setNom(nom);
		try {
			return niveauDao.create(niveau);
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public void ajouterNiveauxInitiaux() {
		if (recupererNiveaux().isEmpty()) {
			ajouterNiveau("Débutant");
			ajouterNiveau("Intermédiaire");
			ajouterNiveau("Expert");

		}

	}

	@Override
	public Niveau recupererNiveau(Long id) {
		try {
			return niveauDao.findOne(id);
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public List<Niveau> recupererNiveaux() {
		try {
			return niveauDao.findAll();
		} catch (SQLException e) {
		}
		return null;

	}

	@Override
	public Niveau majNiveau(Long id, String nom) {
		Niveau niveau = recupererNiveau(id);
		niveau.setNom(nom);
		try {
			return niveauDao.update(niveau);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerNiveau(Long id) {
		try {
			return niveauDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}