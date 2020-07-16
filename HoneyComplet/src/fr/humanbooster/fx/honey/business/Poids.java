package fr.humanbooster.fx.honey.business;

public class Poids {
	private Long id;
	private String nom;
	private float poids;

	public Poids(String nom, float poids) {
		this.nom = nom;
		this.poids = poids;
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

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Poids [id=" + id + ", nom=" + nom + ", poids=" + poids + "]";
	}
	

}
