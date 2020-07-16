package fr.humanbooster.fx.cadeaux.business;

import java.util.List;

public class Categorie {

	private Long id;
	
	private String nom;

	private List<Article> articles;

	public Categorie() {
		super();
	}

	public Categorie(String nom) {
		setNom(nom);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long idCategorie) {
		this.id = idCategorie;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + id + ", nom=" + nom + "]";
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


}
