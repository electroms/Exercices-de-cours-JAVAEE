package fr.humanbooster.fx.docteurhb.business;

public class Parametre {

	private Long id;
	private String nom;

	public Parametre() {
		// TODO Auto-generated constructor stub
	}

	public Parametre(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Parametre [id=" + id + ", nom=" + nom + "]";
	}

}
