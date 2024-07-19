package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Salle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private Integer nbPlace;
	private boolean occuper;
	@OneToOne
	@JoinColumn(name = "videoprojecteur", nullable = true)
	private Videoprojecteur videoprojecteur;
	@OneToMany(mappedBy = "salle")
	private List<MatiereParFormation> matiereParFormation;

	public Salle() {
	}

	public Salle(Integer numero, Integer nbPlace, boolean occuper, Videoprojecteur videoprojecteur,
			List<MatiereParFormation> matiereParFormation) {
		this.numero = numero;
		this.nbPlace = nbPlace;
		this.occuper = occuper;
		this.videoprojecteur = videoprojecteur;
		this.matiereParFormation = matiereParFormation;
	}

	public Integer getNumero() {
		return numero;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
