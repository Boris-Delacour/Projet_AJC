package com.example.demo.dto.response;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.MatiereParFormation;

public class MatiereParFormationResponse {
	
	private Integer id;
	private LocalDate start;
	private LocalDate end;
	
	private MatiereResponse matiere;
	private FormationResponse formation;
	private SalleResponse salle;
	
	private FormateurResponse formateur;

	public MatiereParFormationResponse() {
	}
	
	public MatiereParFormationResponse(MatiereParFormation matiereparformation) {
		this(matiereparformation, true);
	}
	
	public MatiereParFormationResponse(MatiereParFormation matiereparformation, boolean bool) {
		BeanUtils.copyProperties(matiereparformation, this , "matiere","formation","salle","formateur");
		if(bool) {
			if(matiereparformation.getMatiere() != null) {
				this.setMatiere(new MatiereResponse(matiereparformation.getMatiere(),false));
				
			}
			if(matiereparformation.getFormation() != null) {
				this.setFormation(new FormationResponse(matiereparformation.getFormation(),false));
				
			}
			if(matiereparformation.getSalle() != null) {
				this.setSalle(new SalleResponse(matiereparformation.getSalle(),false));
				
			}
			if(matiereparformation.getFormateur() != null) {
				this.setFormateur(new FormateurResponse(matiereparformation.getFormateur(),false));
				
			}
			
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public MatiereResponse getMatiere() {
		return matiere;
	}

	public void setMatiere(MatiereResponse matiere) {
		this.matiere = matiere;
	}

	public FormationResponse getFormation() {
		return formation;
	}

	public void setFormation(FormationResponse formation) {
		this.formation = formation;
	}

	public SalleResponse getSalle() {
		return salle;
	}

	public void setSalle(SalleResponse salle) {
		this.salle = salle;
	}

	public FormateurResponse getFormateur() {
		return formateur;
	}

	public void setFormateur(FormateurResponse formateur) {
		this.formateur = formateur;
	}
	
	
}
