package fr.humanbooster.ph.autoroute.dao;

public class Requetes {

	public static final String AJOUT_PEAGE = "INSERT INTO Peage(nom) VALUES(?)";
	public static final String PEAGE_PAR_ID = "SELECT id, nom FROM Peage WHERE id=?";
	public static final String TOUS_LES_PEAGES = "SELECT id, nom FROM Peage";
	public static final String SUPPRESSION_PEAGE = "DELETE FROM Peage where id=?";
	public static final String MAJ_PEAGE = "UPDATE Peage SET nom=? WHERE id=?";
	
	public static final String AJOUT_CLASSE = "INSERT INTO Classe(nom) VALUES(?)";
	public static final String CLASSE_PAR_ID = "SELECT id, nom FROM Classe WHERE id=?";
	public static final String TOUTES_LES_CLASSES = "SELECT id, nom FROM Classe";
	
	public static final String AJOUT_TARIF = "INSERT INTO Tarif(montant, dateEffet, classe_id, peage_entree_id, peage_sortie_id) VALUES(?, ?, ?, ?, ?)";
	public static final String TARIF_PAR_ID = "SELECT Tarif.id, montant, dateEffet, classe_id, peage_entree_id, peage_sortie_id FROM Tarif WHERE id=?";
	public static final String TOUS_LES_TARIFS = "SELECT Tarif.id, montant, dateEffet, classe_id, peage_entree_id, peage_sortie_id FROM Tarif JOIN Classe ON Classe.id = Tarif.classe_id JOIN Peage AS peage_entree ON peage_entree.id = Tarif.peage_entree_id JOIN Peage AS peage_sortie ON peage_sortie.id = Tarif.peage_sortie_id ORDER BY peage_entree.nom, peage_sortie.nom, Classe.nom";
	public static final String TOUS_LES_TARIFS_BY_ID = "SELECT Tarif.id, montant, dateEffet, classe_id, peage_entree_id, peage_sortie_id FROM Tarif WHERE peage_entree_id=?";
	public static final String SUPPRESSION_TARIF = "DELETE FROM Tarif WHERE id=?";
	public static final String MAJ_TARIF = "UPDATE Tarif SET montant=? WHERE id=?";
	
}
