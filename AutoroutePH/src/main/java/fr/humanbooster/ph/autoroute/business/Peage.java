package fr.humanbooster.ph.autoroute.business;

import java.util.ArrayList;
import java.util.List;

public class Peage {
    
    private Long id;
    private String nom;
    private List<Tarif> tarifsAuDepart;
    
    public Peage() {
    	tarifsAuDepart = new ArrayList<>();
	}

	public Peage(String nom) {
		this();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Tarif> getTarifsAuDepart() {
		return tarifsAuDepart;
	}

	public void setTarifsAuDepart(List<Tarif> tarifsAuDepart) {
		this.tarifsAuDepart = tarifsAuDepart;
	}

	@Override
	public String toString() {
		return "Peage [id=" + id + ", nom=" + nom + "]";
	}
   
}