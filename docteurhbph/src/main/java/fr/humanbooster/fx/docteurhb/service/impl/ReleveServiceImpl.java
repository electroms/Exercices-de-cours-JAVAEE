package fr.humanbooster.fx.docteurhb.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;
import fr.humanbooster.fx.docteurhb.business.Patient;
import fr.humanbooster.fx.docteurhb.business.Releve;
import fr.humanbooster.fx.docteurhb.dao.ReleveDao;
import fr.humanbooster.fx.docteurhb.dao.impl.ReleveDaoImpl;
import fr.humanbooster.fx.docteurhb.service.ReleveService;

public class ReleveServiceImpl implements ReleveService {

	private ReleveDao releveDao = new ReleveDaoImpl();

	@Override
	public Releve ajouterReleve(Releve releve) {
		try {
			return releveDao.create(releve);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Releve recupererReleve(Long id, Date dateEnvoi, Patient patient, Parametre parametre, Float valeur) {
		try {
			return releveDao.findOne(id, (java.sql.Date) dateEnvoi, patient, parametre, valeur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Releve> recupererReleves() {
		try {
			return releveDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Releve majReleve(Releve releve) {
		Releve releveTemp = new Releve();
		try {
			return releveDao.update(releveTemp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerReleve(Long id) {
		try {
			return releveDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
