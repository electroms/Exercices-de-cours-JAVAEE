package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Partie;

public interface PartieService {

	Partie ajouterPartie(Partie partie);

	Partie recupererPartie(Long id);

	List<Partie> recupererParties();

	boolean supprimerPartie(Long id);

}
