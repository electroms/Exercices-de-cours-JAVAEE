package fr.humanbooster.fx.cadeaux.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Categorie;
import fr.humanbooster.fx.cadeaux.service.CategorieService;

public class CategorieServiceImpl implements CategorieService {

	private static List<Categorie> categories = new ArrayList<>();
	
	@Override
	public List<Categorie> recupereCategories() {
		return categories;
	}

	@Override
	public Categorie ajouterCategorie(String nom) {
		Categorie categorie = new Categorie();
		categorie.setNom(nom);
		categories.add(categorie);
		return categorie;
	}
	
}
