package fr.humanbooster.fx.cadeaux.service;

import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Ville;

public interface VilleService {

	public Ville ajouterVille(String nom);
	
	public List<Ville> recupererVilles();
	
	public Ville recupererVilleParId(Long id);
	
	
}
