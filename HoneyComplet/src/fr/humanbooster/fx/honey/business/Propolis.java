package fr.humanbooster.fx.honey.business;

import fr.humanbooster.fx.honey.decorator.PotDecorator;

public class Propolis extends PotDecorator {

	private static final float PRIX = 0.8f;

	public Propolis(Pot pot) {
		super(pot);
		super.setPrix(pot.getPrix() + PRIX);
		super.setNom(pot.getNom() + " " + this.getClass().getSimpleName());
		super.setEtiquette(pot.getEtiquette());
		super.setPoids(pot.getPoids());
		super.setMiel(pot.getMiel());
	}

}