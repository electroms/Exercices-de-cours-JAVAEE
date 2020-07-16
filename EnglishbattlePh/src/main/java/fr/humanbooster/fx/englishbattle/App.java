package fr.humanbooster.fx.englishbattle;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.QuestionService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

public class App {
	
	private static VerbeService verbeService = new VerbeServiceImpl();
    private static JoueurService joueurService = new JoueurServiceImpl();
    private static VilleService villeService = new VilleServiceImpl();
    private static NiveauService niveauService = new NiveauServiceImpl();
    private static PartieService partieService = new PartieServiceImpl();
    private static QuestionService questionService = new QuestionServiceImpl();
    
    public static void main(String[] args) {
        
        verbeService.ajouterVerbesInitiaux();
        villeService.ajouterVillesInitials();
        niveauService.ajouterNiveauxInitiaux();
        joueurService.ajouterJoueurInitial();
        
        Partie partie = new Partie(joueurService.recupererJoueur(3l));
        
        Question question = questionService.ajouterQuestion(new Question(partieService.ajouterPartie(partie), verbeService.recupererVerbeAleatoire()));

        System.out.println(question);
    }

}