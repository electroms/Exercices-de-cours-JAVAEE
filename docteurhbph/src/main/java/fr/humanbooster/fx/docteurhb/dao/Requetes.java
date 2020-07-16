package fr.humanbooster.fx.docteurhb.dao;

public class Requetes {

	// CRUD Parametre

	public static final String AJOUT_PARAMETRE = "INSERT INTO Parametre(id, nom) VALUES (?, ?)";
	public static final String PARAMETRE_PAR_ID_ET_NOM = "SELECT id,nom FROM Parametre WHERE id=? AND nom=?";
	public static final String TOUS_LES_PARAMETRES = "SELECT id, nom FROM Parametre";
	public static final String UPDATE_PARAMETRE = "UPDATE Parametre SET nom = ? where id=?";
	public static final String SUPPRESSION_PARAMETRE = "DELETE FROM Parametre WHERE id=?";

	// CRUD Patient

	public static final String AJOUT_PATIENT = "INSERT INTO Patient (id, dateDeNaissance, nom, prenom) VALUES (?, now(), ?, ?)";
	public static final String TOUS_LES_PATIENTS = "SELECT id, dateDeNaissance,nom, prenom FROM Patient";
	public static final String PATIENT_PAR_ID_ET_NOM = "SELECT id, nom FROM Patient WHERE id=? AND nom=?";
	public static final String UPDATE_PATIENT = "UPDATE Patient SET nom = ? where id=?";
	public static final String SUPPRESSION_PATIENT = "DELETE FROM Patient WHERE id=?";

	// CRUD Releve

	public static final String AJOUT_RELEVE = "INSERT INTO Releve(id, dateEnvoi, patient, parametre, valeur) VALUES (?, ?, ?, ?, ?)";
	public static final String TOUS_LES_RELEVES = "SELECT id, dateEnvoi, patient, parametre, valeur FROM Releve";
	public static final String RELEVE_PAR_ID_ET_PATIENT = "SELECT id, dateEnvoi, patient, parametre, valeur FROM Releve WHERE id=? AND patient=?";
	public static final String UPDATE_RELEVE = "UPDATE Releve SET patient = ? where id=?";
	public static final String SUPPRESSION_RELEVE = "DELETE FROM Releve WHERE id=?";
}
