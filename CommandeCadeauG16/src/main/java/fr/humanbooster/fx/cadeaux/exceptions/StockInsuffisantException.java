package fr.humanbooster.fx.cadeaux.exceptions;

public class StockInsuffisantException extends Exception{

	private static final long serialVersionUID = 1L;

	public StockInsuffisantException(String message) {
		super(message);
	}

}
