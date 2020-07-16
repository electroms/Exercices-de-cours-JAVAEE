package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Niveau;

public interface NiveauService {

	Niveau ajouterNiveau(String nom);

	void ajouterNiveauxInitiaux();

	Niveau recupererNiveau(Long id);

	List<Niveau> recupererNiveaux();

	Niveau majNiveau(Long id, String nom);

	boolean supprimerNiveau(Long id);

}