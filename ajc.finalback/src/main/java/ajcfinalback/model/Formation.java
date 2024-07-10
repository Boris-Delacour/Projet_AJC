package ajcfinalback.model;

import java.time.LocalDate;

public class Formation {

	private int id;
	private String nom;
	private LocalDate dateStart;
	
	private Gestionnaire gestionnaire;
	private Stagiaire stagiaire;
	private MatiereParFormation matiereParFormation;
	
	
	public Formation() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public LocalDate getDateStart() {
		return dateStart;
	}


	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}


	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}


	public Stagiaire getStagiaire() {
		return stagiaire;
	}


	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}


	public MatiereParFormation getMatiereParFormation() {
		return matiereParFormation;
	}


	public void setMatiereParFormation(MatiereParFormation matiereParFormation) {
		this.matiereParFormation = matiereParFormation;
	}
	
	
	
}
