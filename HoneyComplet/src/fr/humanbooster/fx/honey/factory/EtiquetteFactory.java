package fr.humanbooster.fx.honey.factory;

import fr.humanbooster.fx.honey.business.Etiquette;

/**
 * Cette factory est un singleton
 * 
 * @author fx
 *
 */
public class EtiquetteFactory {
	private int nbEtiquettesDisponibles = 100;
	private static EtiquetteFactory etiquetteFactory = null;

	private EtiquetteFactory() {

	}

	public final static EtiquetteFactory getInstance() {
		// Le "Double-Checked Singleton"/"Singleton doublement
		// vérifié" permet d'éviter un appel coûteux à synchronized,
		// une fois que l'instanciation est faite.
		if (etiquetteFactory == null) {
			// Le mot-clé synchronized sur ce bloc empêche toute
			// instanciation multiple même par différents "threads".
			// Il est TRES important.
			synchronized (EtiquetteFactory.class) {
				if (etiquetteFactory == null) {
					etiquetteFactory = new EtiquetteFactory();
				}
			}
		}
		return etiquetteFactory;
	}

	/**
	 * Cette méthode renvoie un objet Etiquette
	 * 
	 * @param message à écrire sur l'étiquette
	 * @return
	 */
	public Etiquette ecrireEtiquette(String message) {
		if (message == null) {
			return null;
		}
		if (nbEtiquettesDisponibles == 0) {
			return null;
		}
		nbEtiquettesDisponibles--;
		return new Etiquette(message);

	}

}