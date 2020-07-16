package fr.humanbooster.fx.honey.business;

public class Prix {

	private Poids poids;
	private Miel miel;
	private float prix;
	
	public Prix(Poids poids, Miel miel, float prix) {
		this.poids = poids;
		this.miel = miel;
		this.prix = prix;
	}

	public Poids getPoids() {
		return poids;
	}

	public void setPoids(Poids poids) {
		this.poids = poids;
	}

	public Miel getMiel() {
		return miel;
	}

	public void setMiel(Miel miel) {
		this.miel = miel;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Prix [poids=" + poids + ", miel=" + miel + ", prix=" + prix + "]";
	}

}
