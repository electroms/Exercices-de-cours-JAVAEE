package fr.humanbooster.fx.honey.business;

public class Etiquette {
	private String message = null;

	public Etiquette(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Etiquette [message=" + message + "]";
	}
	
}