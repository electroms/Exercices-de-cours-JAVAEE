package fr.humanbooster.fx.pizza_business;

public class Artichaud extends Legume {
	private float PRIX_D_ACHAT = 0.4f;
    private float PRIX_DE_VENTE = 0.9f;

	public Artichaud(Pizza pizza) {
		super(pizza);
		 // On ajoute au prix d'achat actuel le prix d'achat de l'artichaud
       super.setPrixDAchat(pizza.getPrixDAchat() + PRIX_D_ACHAT);
       super.setPrixDeVente(pizza.getPrixDeVente() + PRIX_DE_VENTE);
       // Le nouveau nom de la pizza est formé par le nom actuel
       // suivi du nom de la classe (Artichaud)
       super.setNom(pizza.getNom() + " " + this.getClass().getSimpleName());
		
	}

}
