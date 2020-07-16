package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.VilleDao;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;
import fr.humanbooster.fx.englishbattle.service.VilleService;

public class VilleServiceImpl implements VilleService {

	private VilleDao villeDao;

	public VilleServiceImpl() {
		villeDao = new VilleDaoImpl();
	}

	@Override
	public Ville ajouterVille(String nom) {
		Ville ville = new Ville();
		ville.setNom(nom);
		try {
			return villeDao.create(ville);
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public void ajouterVillesInitials() {
		if (recupererVilles().isEmpty()) {
			ajouterVille("Montpellier");
			ajouterVille("Clermont-Ferrand");
			ajouterVille("Noirétable");
			ajouterVille("Lyon Ouest");
		}
	}

	@Override
	public Ville recupererVille(Long id) {
		try {
			return villeDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ville> recupererVilles() {
		try {
			return villeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ville majVille(String nom, Long id) {
		Ville ville = recupererVille(id);
		ville.setNom(nom);
		try {
			return villeDao.update(ville);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerVille(Long id) {
		try {
			return villeDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
