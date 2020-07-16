package fr.humanbooster.fx.honey.business;

import fr.humanbooster.fx.honey.iterator.CollectionDeCadeaux;

public class Pot {
	
	private Long id;
	private Etiquette etiquette;
	private Miel miel;
	private Poids poids;
	private String nom;
	private float prix;
	private CollectionDeCadeaux collectionDeCadeaux = new CollectionDeCadeaux();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Pot() {
		super();
	}
	
	public Pot(Etiquette etiquette) {
		this();
		this.etiquette = etiquette;
	}
	
	public Pot(Etiquette etiquette, Miel miel, Poids poids) {
		super();
		this.etiquette = etiquette;
		this.miel = miel;
		this.poids = poids;
	}
	
	public Miel getMiel() {
		return miel;
	}

	public void setMiel(Miel miel) {
		this.miel = miel;
	}

	public Poids getPoids() {
		return poids;
	}

	public void setPoids(Poids poids) {
		this.poids = poids;
	}

	public Etiquette getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(Etiquette etiquette) {
		this.etiquette = etiquette;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public CollectionDeCadeaux getCollectionDeCadeaux() {
		return collectionDeCadeaux;
	}

	public void setCollectionDeCadeaux(CollectionDeCadeaux collectionDeCadeaux) {
		this.collectionDeCadeaux = collectionDeCadeaux;
	}

	@Override
	public String toString() {
		return "Pot [id=" + id + ", etiquette=" + etiquette + ", miel=" + miel + ", poids=" + poids + ", nom=" + nom
				+ ", prix=" + prix + ", collectionDeCadeaux=" + collectionDeCadeaux + "]";
	}
	
}