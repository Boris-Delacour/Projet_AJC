package ajcfinalback.model;

import java.util.List;

public class Salle {

	private Integer numemo;
	private Integer nbPlace;
	private boolean occuper;
	private Videoprojecteur videoprojecteur;
	private List<MatiereParFormation> matiereParFormation;

	public Salle() {
	}

	public Salle(Integer numemo, Integer nbPlace, boolean occuper, Videoprojecteur videoprojecteur,
			List<MatiereParFormation> matiereParFormation) {
		this.numemo = numemo;
		this.nbPlace = nbPlace;
		this.occuper = occuper;
		this.videoprojecteur = videoprojecteur;
		this.matiereParFormation = matiereParFormation;
	}

	public Integer getNumemo() {
		return numemo;
	}

	public void setNumemo(Integer numemo) {
		this.numemo = numemo;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public boolean isOccuper() {
		return occuper;
	}

	public void setOccuper(boolean occuper) {
		this.occuper = occuper;
	}

	public Videoprojecteur getVideoprojecteur() {
		return videoprojecteur;
	}

	public void setVideoprojecteur(Videoprojecteur videoprojecteur) {
		this.videoprojecteur = videoprojecteur;
	}

	public List<MatiereParFormation> getMatiereParFormation() {
		return matiereParFormation;
	}

	public void setMatiereParFormation(List<MatiereParFormation> matiereParFormation) {
		this.matiereParFormation = matiereParFormation;
	}

}
