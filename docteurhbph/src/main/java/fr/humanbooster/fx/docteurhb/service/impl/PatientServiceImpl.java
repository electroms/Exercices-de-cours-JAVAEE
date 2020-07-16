package fr.humanbooster.fx.docteurhb.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.docteurhb.business.Patient;
import fr.humanbooster.fx.docteurhb.dao.PatientDao;
import fr.humanbooster.fx.docteurhb.dao.impl.PatientDaoImpl;
import fr.humanbooster.fx.docteurhb.service.PatientService;

public class PatientServiceImpl implements PatientService {

	private PatientDao patientDao = new PatientDaoImpl();

	@Override
	public Patient ajouterPatient(Patient patient) {
		try {
			return patientDao.create(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Patient recupererPatient(Long id, Date dateDeNaissance, String nom, String prenom) {
		try {
			return patientDao.findOne(id, (java.sql.Date) dateDeNaissance, nom, prenom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Patient> recupererPateients() {
		try {
            return patientDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public Patient majPatient(Patient patient) {
		Patient patientTemp = new Patient();
		try {
			return patientDao.update(patientTemp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerPatient(Long id) {
		try {
			return patientDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
