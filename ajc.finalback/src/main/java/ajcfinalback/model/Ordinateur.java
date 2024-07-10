package ajcfinalback.model;

public class Ordinateur {
	
	private Integer id;
	private String marque;
	private boolean fonctionnel;
	private String os;
	private Stagiaire stagiaire;
	
	public Ordinateur() {}

	public Ordinateur(Integer id, String marque, boolean fonctionnel, String os, Stagiaire stagiaire) {
		this.id = id;
		this.marque = marque;
		this.fonctionnel = fonctionnel;
		this.os = os;
		this.stagiaire = stagiaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public boolean isFonctionnel() {
		return fonctionnel;
	}

	public void setFonctionnel(boolean fonctionnel) {
		this.fonctionnel = fonctionnel;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	
	
	
	

}
