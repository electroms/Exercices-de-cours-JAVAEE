package fr.humanbooster.fx.englishbattle.business;

import java.util.Calendar;
import java.util.Date;

public class Question {

	private Long id;	
	private Partie partie;	
	private Verbe verbe;
	private String reponsePreterit;
	private String reponseParticipePasse;
	private Date dateEnvoi;
	private Date dateReponse;
	
  public Question() {
  }
	
	public Question(Partie partie, Verbe verbe) {
		this.partie = partie;
		this.verbe = verbe;
		this.dateEnvoi = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Verbe getVerbe() {
		return verbe;
	}

  public void setVerbe(Verbe verbe) {
    this.verbe = verbe;
  }

  public String getReponsePreterit() {
		return reponsePreterit;
	}

	public void setReponsePreterit(String reponsePreterit) {
		this.reponsePreterit = reponsePreterit;
	}

	public String getReponseParticipePasse() {
		return reponseParticipePasse;
	}

	public void setReponseParticipePasse(String reponseParticipePasse) {
		this.reponseParticipePasse = reponseParticipePasse;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Date getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(Date dateReponse) {
		this.dateReponse = dateReponse;
	}

	public long getNbSecondesRestantes() {
		// dateEnvoi + 60 secondes
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateEnvoi);
		calendar.add(Calendar.SECOND, 60);
		Date maintenant = new Date();
		return (calendar.getTime().getTime() - maintenant.getTime())/1000;
	}
	
	@Override
	public String toString() {
		return "Base Verbale : " + verbe + " -  Réponse Preterit : " + reponsePreterit
				+ " - Réponse Participe Passé : " + reponseParticipePasse + " - Date d'envoi : " + dateEnvoi + " - Date Réponse :"
				+ dateReponse;
	}
	
}

