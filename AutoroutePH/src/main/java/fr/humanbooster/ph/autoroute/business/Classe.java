package fr.humanbooster.ph.autoroute.business;

public class Classe {
    
    private Long id;
    private String nom;
    
    public Classe() {
    }

	public Classe(String nom) {
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
		return "Classe [id=" + id + ", nom=" + nom + "]";
	}
    
}
