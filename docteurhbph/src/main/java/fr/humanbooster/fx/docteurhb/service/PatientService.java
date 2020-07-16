package fr.humanbooster.fx.docteurhb.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Patient;

public interface PatientService {

	Patient ajouterPatient(Patient patient);

	Patient recupererPatient(Long id, Date dateDeNaissance, String nom, String prenom);

	List<Patient> recupererPateients();

	Patient majPatient(Patient patient);

	boolean supprimerPatient(Long id);

}
