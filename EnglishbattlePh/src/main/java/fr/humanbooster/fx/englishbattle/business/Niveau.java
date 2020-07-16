package fr.humanbooster.fx.englishbattle.business;

public class Niveau {
  private Long id;
  private String nom;
  
  public Niveau() {
    // TODO Auto-generated constructor stub
  }
  
  
  /**
   * @param nom
   */
  public Niveau(String nom) {
    super();
    this.nom = nom;
  }
  

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the nom
   */
  public String getNom() {
    return nom;
  }

  /**
   * @param nom the nom to set
   */
  public void setNom(String nom) {
    this.nom = nom;
  }


  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return  nom;
  }
  
  

}
