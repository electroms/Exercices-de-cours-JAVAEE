package fr.humanbooster.fx.honey.business;

public class Miel {
	
	private String nom;

	public Miel() {
	}

	public Miel(String nom) {
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
		return "Miel [nom=" + nom + "]";
	}

}