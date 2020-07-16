package fr.humanbooster.ph.autoroute.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Classe;
import fr.humanbooster.ph.autoroute.dao.ClasseDao;
import fr.humanbooster.ph.autoroute.dao.impl.ClasseDaoImpl;
import fr.humanbooster.ph.autoroute.service.ClasseService;

public class ClasseServiceImpl implements ClasseService {

	private ClasseDao classeDao;
	
	public ClasseServiceImpl() {
		classeDao = new ClasseDaoImpl();
	}
	
	@Override
	public Classe ajouterClasse(String nom) {
		Classe classe = new Classe();
		classe.setNom(nom);
		try {
			return classeDao.create(classe);
		} catch (SQLException e) {
		}
		return null;
	}
	
	@Override
	public void ajouterClassesInitiales() {
		if(recupererClasses().isEmpty()) {
			ajouterClasse("Classe 1");
			ajouterClasse("Classe 2");
			ajouterClasse("Classe 3");
			ajouterClasse("Classe 4");
			ajouterClasse("Classe 5");
		}
	}

	@Override
	public Classe recupererClasse(Long id) {
		try {
			return classeDao.findOne(id);
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public List<Classe> recupererClasses() {
		try {
			return classeDao.findAll();
		} catch (SQLException e) {
		}
		return null;
	}

}
