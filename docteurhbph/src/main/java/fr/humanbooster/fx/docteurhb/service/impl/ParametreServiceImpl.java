package fr.humanbooster.fx.docteurhb.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;
import fr.humanbooster.fx.docteurhb.dao.ParametreDao;
import fr.humanbooster.fx.docteurhb.dao.impl.ParametreDaoImpl;
import fr.humanbooster.fx.docteurhb.service.ParametreService;

public class ParametreServiceImpl implements ParametreService {

	private ParametreDao parametreDao = new ParametreDaoImpl();

	@Override
	public Parametre ajouterParametre(Parametre parametre) {
		try {
			return parametreDao.create(parametre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Parametre recupererParametre(Long id, String nom) {
		try {
			return parametreDao.findOne(id, nom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Parametre> recupererParametres() {
		try {
			return parametreDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Parametre majParametre(Parametre parametre) {
		Parametre parametreTemp = new Parametre();
		try {
			return parametreDao.update(parametreTemp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerParametre(Long id, String nom) {
		try {
			return parametreDao.delete(id, nom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
