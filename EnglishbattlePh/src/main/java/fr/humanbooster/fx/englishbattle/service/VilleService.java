package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;

public interface VilleService {

	Ville ajouterVille(String nom);	
	void ajouterVillesInitials();

	Ville recupererVille(Long id);
	
	List<Ville> recupererVilles();

	Ville majVille(String nom, Long id);

	boolean supprimerVille(Long id);
}
