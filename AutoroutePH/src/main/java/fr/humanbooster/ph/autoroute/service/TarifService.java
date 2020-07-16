package fr.humanbooster.ph.autoroute.service;

import java.util.List;

import fr.humanbooster.ph.autoroute.business.Tarif;

public interface TarifService {

	//Create
	Tarif ajouterTarif(Tarif tarif);
	void ajouterTarifsInitiaux();

	//Read
	Tarif recupererTarif(Long id);
	List<Tarif> recupererTarifs();
	List<Tarif> recupererTarifsParPeage(Long idPeage);

	//Update
	Tarif majTarif(Long id, float montant);
	
	//Delete
	boolean supprimerTarif(Long id);



	
}
