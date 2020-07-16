package fr.humanbooster.fx.docteurhb.service;

import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;

public interface ParametreService {

	Parametre ajouterParametre(Parametre parametre);

	Parametre recupererParametre(Long id, String nom);

	List<Parametre> recupererParametres();

	Parametre majParametre(Parametre parametre);

	boolean supprimerParametre(Long id, String nom);

}
