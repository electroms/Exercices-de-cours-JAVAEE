package fr.humanbooster.fx.docteurhb.business;

import java.util.Date;

public class Releve {

	private Long id;
	private Date dateEnvoi;
	private Patient patient;
	private Parametre parametre;
	private float valeur;

	public Releve() {
		// TODO Auto-generated constructor stub
	}

	public Releve(Date dateEnvoi, Patient patient, Parametre parametre, float valeur) {
		super();
		this.dateEnvoi = dateEnvoi;
		this.patient = patient;
		this.parametre = parametre;
		this.valeur = valeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Parametre getParametre() {
		return parametre;
	}

	public void setParametre(Parametre parametre) {
		this.parametre = parametre;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return "Releve [id=" + id + ", dateEnvoi=" + dateEnvoi + ", patient=" + patient + ", parametre=" + parametre
				+ ", valeur=" + valeur + "]";
	}

}
