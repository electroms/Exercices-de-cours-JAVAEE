package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;

public interface VerbeService {

	Verbe ajouterVerbe(String baseVerbal, String preterit, String participePasse, String traduction);

	void ajouterVerbesInitiaux();

	List<Verbe> recupererVerbes();

	Verbe recupererVerbe(Long id);

	Verbe recupererVerbeAleatoire();

	boolean supprimerVerbe(Long id);

	void importerVerbes();

}
