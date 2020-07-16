package fr.humanbooster.ph.autoroute.service.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.humanbooster.ph.autoroute.business.Classe;
import fr.humanbooster.ph.autoroute.business.Peage;
import fr.humanbooster.ph.autoroute.business.Tarif;
import fr.humanbooster.ph.autoroute.dao.TarifDao;
import fr.humanbooster.ph.autoroute.dao.impl.TarifDaoImpl;
import fr.humanbooster.ph.autoroute.service.ClasseService;
import fr.humanbooster.ph.autoroute.service.PeageService;
import fr.humanbooster.ph.autoroute.service.TarifService;

public class TarifServiceImpl implements TarifService {

	private TarifDao tarifDao;
	private ClasseService classeService;
	private PeageService peageService;
	private static Long compteur = 0l;
	
	public TarifServiceImpl() {
		tarifDao = new TarifDaoImpl();
		classeService = new ClasseServiceImpl();
		peageService = new PeageServiceImpl();
	}
	
	@Override
	public Tarif ajouterTarif(Tarif tarif) {
		try {
			return tarifDao.create(tarif);
		} catch (SQLException e) {
		}
		return null;
	}
	
	@Override
	public void ajouterTarifsInitiaux() {
		if(recupererTarifs().isEmpty()) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, 2020);
			calendar.set(Calendar.MONTH, Calendar.MARCH);
			calendar.set(Calendar.DAY_OF_MONTH, 01);
			for(int i = 0; i < 10; i++) {
				Random random = new Random();
				Tarif tarif = new Tarif();
				List<Classe> classes = classeService.recupererClasses();
				Collections.shuffle(classes);
				List<Peage> peages = peageService.recupererPeages();
				Collections.shuffle(peages);
				
				tarif.setId(++compteur);
				tarif.setMontant(1+random.nextInt(10));
				tarif.setDateEffet(calendar.getTime());
				tarif.setClasse(classes.get(0));
				tarif.setPeageEntree(peages.get(0));
				tarif.setPeageSortie(peages.get(1));
				ajouterTarif(tarif);
			}
		}
	}

	@Override
	public Tarif recupererTarif(Long id) {
		try {
			return tarifDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tarif> recupererTarifs() {
		try {
			return tarifDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Tarif> recupererTarifsParPeage(Long idPeage) {
		try {
			return tarifDao.findAllByIdPeageDepart(idPeage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Tarif majTarif(Long id, float montant) {
		Tarif tarif = new Tarif();
		tarif.setId(id);
		tarif.setMontant(montant);
		try {
			return tarifDao.update(tarif);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerTarif(Long id) {
		try {
			return tarifDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
