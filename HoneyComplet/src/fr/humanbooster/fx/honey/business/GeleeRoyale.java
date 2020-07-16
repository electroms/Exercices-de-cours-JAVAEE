package fr.humanbooster.fx.honey.business;

import fr.humanbooster.fx.honey.decorator.PotDecorator;

public class GeleeRoyale extends PotDecorator {

	private static final float PRIX = 1.2f;

	public GeleeRoyale(Pot pot) {
		super(pot);
		super.setPrix(pot.getPrix() + PRIX);
		super.setNom(pot.getNom() + " " + this.getClass().getSimpleName());
		super.setEtiquette(pot.getEtiquette());
		super.setPoids(pot.getPoids());
		super.setMiel(pot.getMiel());
	}

}
