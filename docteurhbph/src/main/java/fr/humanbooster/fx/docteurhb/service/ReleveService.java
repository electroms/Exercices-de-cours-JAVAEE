package fr.humanbooster.fx.docteurhb.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Parametre;
import fr.humanbooster.fx.docteurhb.business.Patient;
import fr.humanbooster.fx.docteurhb.business.Releve;

public interface ReleveService {

	Releve ajouterReleve(Releve releve);

	Releve recupererReleve(Long id, Date dateEnvoi, Patient patient, Parametre parametre, Float valeur);

	List<Releve> recupererReleves();

	Releve majReleve(Releve releve);

	boolean supprimerReleve(Long id);

}
