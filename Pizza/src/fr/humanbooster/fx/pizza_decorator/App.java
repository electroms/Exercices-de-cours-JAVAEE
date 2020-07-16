package fr.humanbooster.fx.pizza_decorator;

import fr.humanbooster.fx.pizza_business.Artichaud;
import fr.humanbooster.fx.pizza_business.Chorizzo;
import fr.humanbooster.fx.pizza_business.Mozzarella;
import fr.humanbooster.fx.pizza_business.Pizza;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pizza pizza = new Artichaud(new Chorizzo(new Mozzarella(new Pizza())));
		
		System.out.println(pizza);
		
		Pizza pizza2 = new Pizza();
		pizza2 = new Mozzarella(pizza2);
		pizza2 = new Artichaud(pizza2);
		
		System.out.println(pizza2);
	}

}
