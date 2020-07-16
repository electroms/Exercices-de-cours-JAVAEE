package fr.humanbooster.fx.pizza_business;

public class Chorizzo extends Viande {
	
	private float PRIX_D_ACHAT = 0.6f;
    private float PRIX_DE_VENTE = 1.2f;

	public Chorizzo(Pizza pizza) {
		super(pizza);
		 // On ajoute au prix d'achat actuel le prix d'achat du Chorizzo
        super.setPrixDAchat(pizza.getPrixDAchat() + PRIX_D_ACHAT);
        super.setPrixDeVente(pizza.getPrixDeVente() + PRIX_DE_VENTE);
        // Le nouveau nom de la pizza est formé par le nom actuel
        // suivi du nom de la classe (Chorizzo)
        super.setNom(pizza.getNom() + " " + this.getClass().getSimpleName());
	}

}
