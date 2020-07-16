package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.dao.PartieDao;
import fr.humanbooster.fx.englishbattle.dao.impl.PartieDaoImpl;
import fr.humanbooster.fx.englishbattle.service.PartieService;

public class PartieServiceImpl implements PartieService {

	private PartieDao partieDao = new PartieDaoImpl();

	@Override
	public Partie ajouterPartie(Partie partie) {
		try {
			return partieDao.create(partie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Partie recupererPartie(Long id) {
		try {
			return partieDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Partie> recupererParties() {
		try {
			return partieDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerPartie(Long id) {
		try {
			return partieDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
