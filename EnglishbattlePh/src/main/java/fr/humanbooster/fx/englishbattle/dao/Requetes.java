package fr.humanbooster.fx.englishbattle.dao;

public class Requetes {
	
	// CRUD Partie
	
	public static final String AJOUT_PARTIE = "INSERT INTO Partie (joueur_id) VALUES (?)";

	public static final String TOUTES_LES_PARTIES = "SELECT id, joueur_id FROM Partie";

	public static final String PARTIE_PAR_ID = "SELECT id, joueur_id FROM Partie WHERE id=?";
	
	public static final String SUPPRESSION_PARTIE = "DELETE FROM Partie WHERE id=?";
	

	// CRUD Ville
	
	public static final String AJOUT_VILLE = "INSERT INTO Ville (nom) VALUES (?)";
	
	public static final String TOUTES_LES_VILLES = "SELECT id, nom FROM Ville";

	public static final String VILLE_PAR_ID = "SELECT id, nom FROM Ville WHERE id=?";
	
	public static final String MODIFICATION_VILLE = "UPDATE Ville SET nom=? WHERE id=?";
	
	public static final String SUPPRESSION_VILLE = "DELETE FROM Ville WHERE id=?";
	
	
	// CRUD Niveau
	
	public static final String AJOUT_NIVEAU = "INSERT INTO Niveau (nom) VALUES (?)";
	
	public static final String TOUT_LES_NIVEAU = "SELECT id, nom FROM Niveau";

	public static final String NIVEAU_PAR_ID = "SELECT id, nom FROM Niveau WHERE id=?";
	
	public static final String MODIFICATION_NIVEAU = "UPDATE Niveau SET nom=? WHERE id=?";
	
	public static final String SUPPRESSION_NIVEAU = "DELETE FROM Niveau WHERE id=?";
	
	//CRUD Joueur
	
	 public static final String TOUS_LES_JOUEURS = "SELECT id, email, motDePasse, nom, prenom, niveau_id, ville_id FROM Joueur";
	  
	 public static final String JOUEUR_PAR_ID = "SELECT * FROM Joueur WHERE id=?";
	  
	 public static final String AJOUT_JOUEUR = "INSERT INTO Joueur(email, motDePasse, nom, prenom, niveau_id, ville_id) VALUES (?, ?, ?, ?, ?, ?)";
	      
	 public static final String SUPPRESSION_JOUEUR = "DELETE FROM Joueur WHERE id=?";   
	  
	 public static final String JOUEUR_PAR_MAIL_ET_MDP = "SELECT id, email, motDePasse, nom, prenom, niveau_id, ville_id FROM Joueur WHERE email=? AND motDePasse=?";
	  
	 public static final String UPDATE_JOUEUR_MOT_DE_PASSE = "UPDATE Joueur SET motDePasse = ? where id=?";
	 
	 //CRUD Question
	 
	public static final String TOUTES_LES_QUESTIONS = "SELECT id, dateEnvoi, dateReponse, reponseParticipePasse, reponsePreterit, partie_id, verbe_id FROM Question";
		
	public static final String QUESTION_PAR_ID = "SELECT * FROM Question WHERE id=?";
		
	public static final String AJOUT_QUESTION = "INSERT INTO Question (dateEnvoi, partie_id, verbe_id) VALUES (now(), ?, ?)";
		
	public static final String SUPPRESSION_QUESTION = "DELETE FROM Question WHERE id=?" ;
	
	public static final String MODIFICATION_QUESTION = " UPDATE Question SET dateReponse=now(), reponseParticipePasse=?, reponsePreterit=? where id=?";
	
	//CRUD Verbe
	
	public static final String AJOUT_VERBE = "INSERT INTO Verbe (baseVerbale, participePasse, preterit, traduction) VALUES (?, ?, ?, ?)";
	
	public static final String TOUS_LES_VERBES = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM Verbe";
	
	public static final String TOUS_LES_VERBES_ALEATOIRE = "SELECT * FROM Verbe ORDER BY rand()";

	public static final String VERBE_PAR_ID = "SELECT * FROM Verbe WHERE id=?";
	
	public static final String MODIFICATION_VERBE = "UPDATE Verbe SET baseVerbale=?, participePasse=?, preterit=?, traduction=? WHERE id=?";
	
	public static final String SUPPRESSION_VERBE = "DELETE FROM Verbe WHERE id=?";
			
}
