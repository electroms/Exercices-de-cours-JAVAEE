package fr.humanbooster.fx.cadeaux.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.exceptions.StockInsuffisantException;

public interface CommandeService {

	public List<Commande> recupererCommandesUtilisateur(Utilisateur utilisateur);

	public List<Commande> recupererCommandesArticle(Article article);
	
	public Commande recupererCommandeUtilisateurByID(Utilisateur utilisateur, Long id);
	
	public Commande recupererCommandeArticleByID(Article article, Long id);
	
	public Commande ajouterCommande(Date dateCommande, int quantite, Article article, Utilisateur utilisateur) throws StockInsuffisantException;
}
