package fr.humanbooster.fx.cadeaux.service.impl;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.exceptions.StockInsuffisantException;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.CommandeService;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;

public class CommandeServiceImpl implements CommandeService {
	
	private UtilisateurService utilisateurService = new UtilisateurServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();
	
	
	@Override
	public List<Commande> recupererCommandesUtilisateur(Utilisateur utilisateur) {
		return utilisateur.getCommandes();
	}

	@Override
	public List<Commande> recupererCommandesArticle(Article article) {
		return article.getCommandes();
	}

	@Override
	public Commande recupererCommandeUtilisateurByID(Utilisateur utilisateur, Long id) {
		Commande maCommande = null;
		for(Commande commande : utilisateur.getCommandes()) {
			if(commande.getId() == id) {
				maCommande = commande;
				break;
			}
		}
		return maCommande;
	}

	@Override
	public Commande recupererCommandeArticleByID(Article article, Long id) {
		Commande maCommande = null;
		for(Commande commande : article.getCommandes()) {
			if(commande.getId() == id) {
				maCommande = commande;
				break;
			}
		}
		return maCommande;
	}

	@Override
	public Commande ajouterCommande(Date dateCommande, int quantite, Article article, Utilisateur utilisateur) throws StockInsuffisantException{
		
		if(quantite > article.getStock()) {
			throw new StockInsuffisantException("Impossible de commander plus que le stock disponible");
		}
		Commande commande = new Commande();
		commande.setDateCommande(dateCommande);
		commande.setQuantite(quantite);
		commande.setArticle(article);
		commande.setUtilisateur(utilisateur);
		utilisateurService.ajouterCommande(utilisateur, commande);
		articleService.ajouterCommande(article, commande);
		articleService.majStock(article, article.getStock() - quantite);
		return commande;
	}

}
