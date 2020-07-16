package fr.humanbooster.fx.docteurhb.business;

import java.util.Date;

public class Patient {

	private Long id;
	private Date dateDeNaissance;
	private String nom;
	private String prenom;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, Date dateDeNaissance, String nom, String prenom) {
		super();
		this.id = id;
		this.dateDeNaissance = dateDeNaissance;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", dateDeNaissance=" + dateDeNaissance + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}

}
