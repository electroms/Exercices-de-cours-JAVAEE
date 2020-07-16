package fr.humanbooster.fx.cadeaux.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.business.Ville;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {

	private static List<Utilisateur> utilisateurs = new ArrayList<>();

	@Override
	public Utilisateur creerUtilisateur(String nom, String prenom, String email, String mdp, Ville ville) {
		Utilisateur utilisateur = new Utilisateur(nom, prenom, email, mdp, ville);
		utilisateurs.add(utilisateur);
		// TODO envoi d'un mail de confirmation pour valider son inscription
		return utilisateur;
	}

	@Override
	public List<Utilisateur> recupererUtilisateurs() {
		return utilisateurs;
	}

	@Override
	public Utilisateur recupererUtilisateurByID(Long id) {
		Utilisateur monUtilisateur = null;
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id) {
				monUtilisateur = utilisateur;
				break;
			}
		}
		return monUtilisateur;
	}

	@Override
	public Utilisateur recupererUtilisateurParEmailEtMDP(String email, String motDePasse) {
		Utilisateur monUtilisateur = null;
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getEmail().equals(email)) {
				if(utilisateur.getMotDePasse().equals(motDePasse)) {
					monUtilisateur = utilisateur;
					break;
				}
			}
		}
		return monUtilisateur;
	}

	@Override
	public void ajouterCommande(Utilisateur utilisateur, Commande commande) {
		utilisateur.getCommandes().add(commande);
	}
	
}
