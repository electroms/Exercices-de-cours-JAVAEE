package fr.humanbooster.fx.honey.decorator;

import fr.humanbooster.fx.honey.business.Pot;

public class PotDecorator extends Pot {

	  protected Pot pot;
	  
	  public PotDecorator(Pot pot) {
	    super();
	    this.pot = pot;
	  }

}