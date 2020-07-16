package fr.humanbooster.fx.honey.business;

public class Cadeau {
	private String nom;

	public Cadeau(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Cadeau [nom=" + nom + "]";
	}
	
	

}
