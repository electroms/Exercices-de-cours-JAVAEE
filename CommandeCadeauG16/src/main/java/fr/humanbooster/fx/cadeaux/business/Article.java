package fr.humanbooster.fx.cadeaux.business;

import java.util.ArrayList;
import java.util.List;

public class Article {

	private Long id;
	private String designation;
	private int nbPoints;
	private int stock;
	private Categorie categorie;
	private String description;
	private List<Commande> commandes;
	private static Long counter = 0L;

	public Article() {
		super();
		id = ++counter;
		this.commandes = new ArrayList<Commande>();
	}

	public Article(String designation, Categorie categorie, int nbPoints, int stock) {
		this();
		setDesignation(designation);
		setCategorie(categorie);
		setNbPoints(nbPoints);
		setStock(stock);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idArticle) {
		this.id = idArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + id + ", designation=" + designation + ", nbPoints=" + nbPoints + ", stock="
				+ stock + ", categorie=" + categorie + "]";
	}

}
