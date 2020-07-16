package fr.humanbooster.fx.cadeaux.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utilisateur {

	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private Date dateInscription;
	private Ville ville;
	private List<Commande> commandes;
	private static Long counter = 0L;
	
	public Utilisateur() {
		super();
		this.id = ++counter;
		this.commandes = new ArrayList<Commande>();
	}
	
	public Utilisateur(String nom, String prenom, String email, String mdp, Ville ville) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = mdp;
		this.dateInscription = new Date();
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idUtilisateur) {
		this.id = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", motDePasse=" + motDePasse + ", dateInscription=" + dateInscription + ", ville=" + ville
				+ "]";
	}
	
	
}
