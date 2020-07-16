package fr.humanbooster.ph.autoroute.service;

import java.util.List;

import fr.humanbooster.ph.autoroute.business.Classe;

public interface ClasseService {

	//Create
	Classe ajouterClasse(String nom);
	void ajouterClassesInitiales();

	//Read
	Classe recupererClasse(Long id);
	List<Classe> recupererClasses();

}
