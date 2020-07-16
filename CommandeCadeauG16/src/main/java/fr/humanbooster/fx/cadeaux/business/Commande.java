package fr.humanbooster.fx.cadeaux.business;

import java.util.Date;

public class Commande {

	private Long id;
	private Date dateCommande;
	private int quantite;
	private Article article;
	private Utilisateur utilisateur;
	private static Long counter = 0L;
	
	public Commande() {
		super();
		this.id = ++counter;
	}

	public Commande(Date dateCommande, int quantite, Article article, Utilisateur utilisateur) {
		this();
		this.dateCommande = dateCommande;
		this.quantite = quantite;
		this.article = article;
		this.utilisateur = utilisateur;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long idCommande) {
		this.id = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + id + ", dateCommande=" + dateCommande + ", quantite=" + quantite
				+ ", article=" + article + ", utilisateur=" + utilisateur + "]";
	}
	
	
}
