package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;

public interface JoueurService {

	public Joueur ajouterJoueur(String nom, String prenom, String motDePasse, String email, Ville ville, Niveau niveau);

	Joueur ajouterJoueur(Joueur joueur);

	void ajouterJoueurInitial();

	Joueur recupererJoueur(Long id);

	Joueur recupererJoueur(String email, String mdp);

	List<Joueur> recupererJoueurs();

	Joueur majJoueur(Joueur joueur);

	boolean supprimerJoueur(Long id);

}
