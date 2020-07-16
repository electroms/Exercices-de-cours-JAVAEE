package fr.humanbooster.fx.honey;

import java.util.Scanner;

import fr.humanbooster.fx.honey.builders.PotBuilder;
import fr.humanbooster.fx.honey.business.BrisuresDeTruffesNoires;
import fr.humanbooster.fx.honey.business.Cadeau;
import fr.humanbooster.fx.honey.business.GeleeRoyale;
import fr.humanbooster.fx.honey.business.HuileEssentielleDeCitronVert;
import fr.humanbooster.fx.honey.business.Pollen;
import fr.humanbooster.fx.honey.business.Pot;
import fr.humanbooster.fx.honey.business.Propolis;
import fr.humanbooster.fx.honey.business.Rayon;
import fr.humanbooster.fx.honey.factory.EtiquetteFactory;
import fr.humanbooster.fx.honey.iterator.CollectionDeCadeaux;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		PotBuilder potBuilder = new PotBuilder();

		do {
			System.out.println("Numéro\tTarif\tNom");
			System.out.println("1\t0.8\tPropolis");
			System.out.println("2\t2.0\tRayon");
			System.out.println("3\t1.2\tGelée royale");
			System.out.println("4\t1.2\tHuile essentielle de citron vert");
			System.out.println("5\t0.5\tPollen");
			System.out.println("6\t3.2\tBrisures de truffes noires");
			System.out.print("Entrez le numéro de l'ingrédient: ");

			switch (scanner.nextLine()) {
			case "1":
				potBuilder.setPot(new Propolis(potBuilder.getPot()));
				System.out.println("Vous avez ajouté l'ingrédient Propolis");
				break;
			case "2":
				potBuilder.setPot(new Rayon(potBuilder.getPot()));
				System.out.println("Vous avez ajouté l'ingrédient Rayon");
				break;
			case "3":
				potBuilder.setPot(new GeleeRoyale(potBuilder.getPot()));
				System.out.println("Vous avez ajouté l'ingrédient Gelée royale");
				break;
			case "4":
				potBuilder.setPot(new HuileEssentielleDeCitronVert(potBuilder.getPot()));
				System.out.println("Vous avez ajouté l'ingrédient Huile essentielle de citron vert");
				break;
			case "5":
				potBuilder.setPot(new Pollen(potBuilder.getPot()));
				System.out.println("Vous avez ajouté l'ingrédient Pollen");
				break;
			case "6":
				potBuilder.setPot(new BrisuresDeTruffesNoires(potBuilder.getPot()));
				System.out.println("Vous avez ajouté l'ingrédient Brisures de truffes noires");
				break;
			default:
				break;
			}
			System.out.print("Souhaitez-vous ajouter un nouvel ingrédient (O/N) ? ");
		} while (scanner.nextLine().toLowerCase().equals("o"));


		Pot pot = potBuilder.choisirMiel("Lavande").choisirPoids(500).ajouterEtiquette("CDA 16").build();
		System.out.println(pot);
		
		// Patron Iterator
		while (pot.getCollectionDeCadeaux().hasNext()) {
			Cadeau cadeau = (Cadeau) pot.getCollectionDeCadeaux().next();
			System.out.println(cadeau);
		}
		// Le ForEach est possible sur CollectionDeCadeau car elle impl�mente
		// l'interface Iterable
		for (Cadeau cadeau : pot.getCollectionDeCadeaux()) {
			System.out.println(cadeau);
		}

		scanner.close();
	}

}
