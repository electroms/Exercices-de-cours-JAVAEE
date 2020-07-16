package fr.humanbooster.fx.cadeaux.service;

import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Categorie;

public interface CategorieService {

	public List<Categorie> recupereCategories();

	public Categorie ajouterCategorie(String nom);
}
