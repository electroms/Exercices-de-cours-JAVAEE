package fr.humanbooster.fx.pizza_business;

public class Pizza {

    private float PRIX_D_ACHAT = 0.1f;
    private float PRIX_DE_VENTE = 1f;

    private float prixDeVente;
    private float prixDAchat;
    private String nom;

    public Pizza() {
        nom = "Pizza";
        prixDeVente = PRIX_DE_VENTE;
        prixDAchat = PRIX_D_ACHAT;
    }

    public float getPrixDeVente() {
        return prixDeVente;
    }

    public void setPrixDeVente(float prixDeVente) {
        this.prixDeVente = prixDeVente;
    }

    public float getPrixDAchat() {
        return prixDAchat;
    }

    public void setPrixDAchat(float prixDAchat) {
        this.prixDAchat = prixDAchat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Pizza [prixDeVente=" + prixDeVente + ", prixDAchat=" + prixDAchat + ", nom=" + nom + "]";
    }

}
