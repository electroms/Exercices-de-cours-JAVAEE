package fr.humanbooster.ph.autoroute.business;

import java.util.Date;

public class Tarif {

	private Long id;
	private float montant;
	private Date dateEffet;
	private Classe classe;
	private Peage peageEntree;
	private Peage peageSortie;

	public Tarif() {
	}

	public Tarif(Long id, float montant, Date dateEffet, Classe classe, Peage peageEntree, Peage peageSortie) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateEffet = dateEffet;
		this.classe = classe;
		this.peageEntree = peageEntree;
		this.peageSortie = peageSortie;
		this.peageEntree.getTarifsAuDepart().add(this);
	}

	public Tarif(float montant, Date dateEffet, Classe classe, Peage peageEntree, Peage peageSortie) {
		this(null, montant, dateEffet, classe, peageEntree, peageSortie);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Peage getPeageEntree() {
		return peageEntree;
	}

	public void setPeageEntree(Peage peageEntree) {
		this.peageEntree = peageEntree;
	}

	public Peage getPeageSortie() {
		return peageSortie;
	}

	public void setPeageSortie(Peage peageSortie) {
		this.peageSortie = peageSortie;
	}

	@Override
	public String toString() {
		return "Tarif [id=" + id + ", montant=" + montant + ", dateEffet=" + dateEffet + ", classe=" + classe
				+ ", peageEntree=" + peageEntree + ", peageSortie=" + peageSortie + "]";
	}

}