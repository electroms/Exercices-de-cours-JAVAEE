package fr.humanbooster.fx.cadeaux.service;

import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Categorie;
import fr.humanbooster.fx.cadeaux.business.Commande;

public interface ArticleService {

	public List<Article> recupereArticles();

	public Article recupererArticleByID(Long id);
	
	public void ajouterArticle(String designation, int nbPoints, int stock, Categorie categorie);
	
	public void majStock(Article article, int quantite);
	
	public void ajouterCommande(Article article, Commande commande);
}
