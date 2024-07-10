package ajcfinalback.model;

public class Videoprojecteur {
	
	private Integer id;
	private String marque;
	private boolean fonctionnel;
	private Salle salle;
	
	public Videoprojecteur() {}

	public Videoprojecteur(Integer id, String marque, boolean fonctionnel, Salle salle) {
		this.id = id;
		this.marque = marque;
		this.fonctionnel = fonctionnel;
		this.salle = salle;
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

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
	
	

}
