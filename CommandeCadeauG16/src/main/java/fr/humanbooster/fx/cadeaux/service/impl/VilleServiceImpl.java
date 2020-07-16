package fr.humanbooster.fx.cadeaux.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Ville;
import fr.humanbooster.fx.cadeaux.service.VilleService;

public class VilleServiceImpl implements VilleService {

	private static List<Ville> villes = new ArrayList<>();
		
	@Override
	public Ville ajouterVille(String nom) {
		Ville ville = new Ville();
		ville.setNom(nom);
		villes.add(ville);
		return ville;
	}
	
	@Override
	public List<Ville> recupererVilles() {
		return villes;
	}

	@Override
	public Ville recupererVilleParId(Long id) {
		Ville maVille = null;
		for(Ville ville : villes) {
			if(ville.getId() == id) {
				maVille = ville;
				break;
			}
		}
		
		return maVille;
	}

	

}