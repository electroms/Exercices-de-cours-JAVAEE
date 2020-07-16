package fr.humanbooster.fx.cadeaux.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Categorie;
import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private static List<Article> articles = new ArrayList<>();

	
	@Override
	public void ajouterArticle(String designation, int nbPoints, int stock, Categorie categorie) {
		Article article = new Article();
		article.setDescription(designation);
		article.setDesignation(designation);
		article.setNbPoints(nbPoints);
		article.setStock(stock);
		article.setCategorie(categorie);
		articles.add(article);
	}
	
	@Override
	public List<Article> recupereArticles() {
		return articles;
	}

	@Override
	public Article recupererArticleByID(Long id) {
		Article monArticle = null;
		for(Article article : articles) {
			if(article.getId() == id) {
				monArticle = article;
				break;
			}
		}
		return monArticle;
	}

	@Override
	public void majStock(Article article, int quantite) {
		article.setStock(quantite);
	}

	@Override
	public void ajouterCommande(Article article, Commande commande) {
		article.getCommandes().add(commande);
	}


}
