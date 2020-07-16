package fr.humanbooster.ph.autoroute.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Peage;
import fr.humanbooster.ph.autoroute.dao.PeageDao;
import fr.humanbooster.ph.autoroute.dao.impl.PeageDaoImpl;
import fr.humanbooster.ph.autoroute.service.PeageService;

public class PeageServiceImpl implements PeageService {

	private PeageDao peageDao;
	
	public PeageServiceImpl() {
		peageDao = new PeageDaoImpl();
	}
	
	@Override
	public Peage ajouterPeage(String nom) {
		Peage peage = new Peage();
		peage.setNom(nom);
		try {
			return peageDao.create(peage);
		} catch (SQLException e) {
		}
		return null;
	}
	
	@Override
	public void ajouterPeagesInitiaux() {
		if(recupererPeages().isEmpty()) {
			ajouterPeage("Montpellier");
			ajouterPeage("Clermont-Ferrand");
			ajouterPeage("Noirétable");
			ajouterPeage("Lyon Ouest");
		}
	}
	
	@Override
	public Peage recupererPeage(Long id) {
		try {
			return peageDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Peage> recupererPeages() {
		try {
			return peageDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Peage majPeage(String nom, Long id) {
		Peage peage = new Peage();
		peage.setNom(nom);
		peage.setId(id);
		try {
			return peageDao.update(peage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean supprimerPeage(Long id) {
		try {
			return peageDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
