package fr.humanbooster.fx.pizza_business;

public abstract class PizzaDecorator extends Pizza {

    // Le patron Decorator est facilement reconnaissable:
    // Entre Pizza et PizzaDecorator: il y a deux traits:
    // Un trait d'utilisation et un trait d'héritage
    
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        super();
        this.pizza = pizza;
    }
    
}
