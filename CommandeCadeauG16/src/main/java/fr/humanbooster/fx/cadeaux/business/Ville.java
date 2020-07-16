package fr.humanbooster.fx.cadeaux.business;

import java.util.List;

public class Ville {

	private Long id;
	
	private String nom;
	
	private List<Utilisateur> utilisateurs;

	private static Long counter = 0L;
	
	public Ville() {
		this.id = ++counter;
	}
	
	public Ville(String nom) {
		this();
		this.nom = nom;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long idVille) {
		this.id = idVille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@Override
	public String toString() {
		return "Ville [idVille=" + id + ", nom=" + nom + "]";
	}
		
}