package fr.humanbooster.ph.autoroute;

import java.util.Calendar;
import java.util.Scanner;

import fr.humanbooster.ph.autoroute.business.Classe;
import fr.humanbooster.ph.autoroute.business.Tarif;
import fr.humanbooster.ph.autoroute.service.ClasseService;
import fr.humanbooster.ph.autoroute.service.PeageService;
import fr.humanbooster.ph.autoroute.service.TarifService;
import fr.humanbooster.ph.autoroute.service.impl.ClasseServiceImpl;
import fr.humanbooster.ph.autoroute.service.impl.PeageServiceImpl;
import fr.humanbooster.ph.autoroute.service.impl.TarifServiceImpl;

public class App {
			
	private static Scanner scanner = new Scanner(System.in);
	private static PeageService peageService = new PeageServiceImpl();
	private static ClasseService classeService = new ClasseServiceImpl();
	private static TarifService tarifService = new TarifServiceImpl();
	
	public static void main(String[] args) {
		
		peageService.ajouterPeagesInitiaux();	
		classeService.ajouterClassesInitiales();
		tarifService.ajouterTarifsInitiaux();
		
		Integer choix = null;
		do {
			afficherMenu();
			switch (demanderChoix("Veuillez rentrer votre choix : ", 1, 6)) {
			case 1:
				choix = 1;
				afficherTarifs();
				break;
			case 2:
				choix = 2;
				afficherTarifsPourPeageDepart();
				break;
			case 3:
				choix = 3;
				ajouterTarif();
				break;
			case 4:
				choix = 4;
				modifierTarif();
				break;
			case 5:
				choix = 5;
				supprimerTarif();
				break;
			case 6:
				choix = 6;
				System.exit(0);
				break;
			default:
				break;
			}
		}while(choix != 6);
	}

	private static void afficherTarifs() {
		for(Tarif tarif : tarifService.recupererTarifs()) {
			System.out.println(tarif);
		}
	}
	
	private static void afficherTarifsPourPeageDepart() {
		System.out.print("Rentrez l'id du péage de départ : ");
		Long id = Long.parseLong(scanner.nextLine());
		for(Tarif tarif : tarifService.recupererTarifsParPeage(id)) {
			System.out.println(tarif);
		}

	}
	
	private static void ajouterTarif() {
		Tarif tarif = new Tarif();
		afficherClasses();
		System.out.print("Entrez l’id de la classe concerné : ");
		tarif.setClasse(classeService.recupererClasse(Long.parseLong(scanner.nextLine())));
		System.out.print("Entrez l’id du péage d’entrée : ");
		tarif.setPeageEntree(peageService.recupererPeage(Long.parseLong(scanner.nextLine())));
		System.out.print("Entrez l’id du péage de sortie : ");
		tarif.setPeageSortie(peageService.recupererPeage(Long.parseLong(scanner.nextLine())));
		System.out.print("Entrez le montant en euros : ");
		tarif.setMontant(Float.parseFloat(scanner.nextLine()));
		System.out.print("Entrez la date d’effet au format dd/MM/yyyy : ");
		String[] dateEntiere = scanner.nextLine().split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(dateEntiere[2]));
		calendar.set(Calendar.MONTH, Integer.parseInt(dateEntiere[1])-1);
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateEntiere[0]));
		tarif.setDateEffet(calendar.getTime());
		tarifService.ajouterTarif(tarif);
		
		System.out.println("Le tarif a bien été ajouté, il porte l’id " + tarif.getId());
		System.out.println("Classe concernée : " + tarif.getClasse().getNom());
		System.out.println("Péage d’entrée : " + tarif.getPeageEntree().getNom());
		System.out.println("Péage de sortie : " + tarif.getPeageSortie().getNom());
		System.out.println("Date d’effet : " + tarif.getDateEffet());
		System.out.println("Montant en euros : " + tarif.getMontant());
	}
	
	private static void modifierTarif() {
		System.out.print("Rentrez l'id du tarif à modifier : ");
		Long id = Long.parseLong(scanner.nextLine());
		System.out.print("Rentrez le nouveau montant : ");
		float montant = Float.parseFloat(scanner.nextLine());
		tarifService.majTarif(id, montant);
		System.out.println("Le tarif à l'id " + id + " a bien été modifié à " + montant + "€");
		
	}
	
	private static void supprimerTarif() {
		System.out.print("Rentrez l'id du tarif à supprimer : ");
		Long id = Long.parseLong(scanner.nextLine());
		tarifService.supprimerTarif(id);
		System.out.println("Vous avez bien supprimé le tarif à l'id " + id);
	}

	private static void afficherMenu() {
		System.out.println("================");
		System.out.println("Menu principal :");
		System.out.println("================");
		System.out.println("1 : Voir tous les tarifs triés sur le nom du péage d’entrée puis sur le nom du péage de sortie puis sur le nom de la classe");
		System.out.println("2 : Voir tous les tarifs au départ d’un péage (en précisant l’id du péage)");
		System.out.println("3 : Ajouter un tarif");	
		System.out.println("4 : Modifier un tarif (en précisant son id puis le nouveau montant)");
		System.out.println("5 : Supprimer un tarif (en précisant son id)");
		System.out.println("6 : Quitter");
	}
	
	private static void afficherClasses() {
		System.out.println("Voici la liste exhaustive des péages :");
		for (Classe classe : classeService.recupererClasses()) {
			System.out.println(classe);
		}
	}
	
    private static int demanderChoix(String message, int borneMin, int borneMax) {
        int valeur = borneMin-1;
        // Utilisation d'une boucle do while
        // Le code dans le do sera exécuté au moins une fois
        do {
                System.out.print(message);
                try {
                        String saisie = scanner.nextLine();
                        valeur = Integer.parseInt(saisie);
                        if (valeur<borneMin || valeur>borneMax)
                        {
                                System.out.println("Merci de saisir un nombre compris entre " + borneMin + " et " + borneMax );
                        }
                }
                catch (Exception e)
                {
                        System.out.println("Merci de saisir un nombre");
                }

        }
        while (!(valeur>=borneMin && valeur<=borneMax));
        return valeur;
    }
    
}