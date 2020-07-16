package fr.humanbooster.fx.cadeaux.service;

import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.business.Ville;;

public interface UtilisateurService {

	public Utilisateur creerUtilisateur(String nom, String prenom, String email, String mdp, Ville ville);

	public List<Utilisateur> recupererUtilisateurs();
	
	public Utilisateur recupererUtilisateurByID(Long id);
	
	public Utilisateur recupererUtilisateurParEmailEtMDP(String email, String motDePasse);
	
	public void ajouterCommande(Utilisateur utilisateur, Commande commande);
}
