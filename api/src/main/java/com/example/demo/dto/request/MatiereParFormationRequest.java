package com.example.demo.dto.request;

import java.time.LocalDate;

public class MatiereParFormationRequest {

	private LocalDate start;
	private LocalDate end;
	private Integer idMatiere;
	private Integer idFormateur;
	private Integer idFormation;
	private Integer idSalle;
	
	public Integer getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(Integer idFormateur) {
		this.idFormateur = idFormateur;
	}

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	public Integer getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}

	public MatiereParFormationRequest() {
	}
	
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Integer getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Integer idMatiere) {
		this.idMatiere = idMatiere;
	}
	
	
	
}
