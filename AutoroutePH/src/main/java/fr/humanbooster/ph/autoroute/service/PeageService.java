package fr.humanbooster.ph.autoroute.service;

import java.util.List;

import fr.humanbooster.ph.autoroute.business.Peage;

public interface PeageService {

	//Create
	Peage ajouterPeage(String nom);
	void ajouterPeagesInitiaux();

	//Read
	Peage recupererPeage(Long id);
	List<Peage> recupererPeages();

	//Update
	Peage majPeage(String nom, Long id);
	
	//Delete
	boolean supprimerPeage(Long id);
	
}
