package com.example.demo.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Formation;
import com.fasterxml.jackson.annotation.JsonView;

public class FormationResponse {

	@JsonView(CustomJsonViews.Common.class)
    private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private String nom;
	@JsonView(CustomJsonViews.Common.class)
	private LocalDate dateStart;

	@JsonView(CustomJsonViews.FormationWithAll.class)
    private GestionnaireResponse gestionnaire;
	@JsonView(CustomJsonViews.FormationWithAll.class)
    private List<StagiaireResponse> stagiaires;
	@JsonView(CustomJsonViews.FormationWithAll.class)
    private List<MatiereParFormationResponse> matiereParFormations;
	@JsonView(CustomJsonViews.FormationWithAll.class)
    private FormateurResponse formateur;

    public FormationResponse() {
    }

	public FormationResponse(Formation formation) {
		this(formation, false);
    }

    public FormationResponse(Formation formation, boolean bool) {
        BeanUtils.copyProperties(formation, this, "gestionnaire", "stagiaires", "matieresParFormations", "formateur");
        if (bool) {
            if (formation.getGestionnaire() != null) {
				this.setGestionnaire(new GestionnaireResponse(formation.getGestionnaire(),false));
			}
			if (formation.getStagiaires() != null) {
				this.setStagiaires(formation.getStagiaires().stream()
						.map(stagiaire -> new StagiaireResponse(stagiaire, false))
						.collect(Collectors.toList()));
			}
            if (formation.getMatiereParFormation() != null) {
				this.setMatiereParFormations(formation.getMatiereParFormation().stream()
						.map(matiereParFormations -> new MatiereParFormationResponse(matiereParFormations, false))
						.collect(Collectors.toList()));
			}
            if (formation.getFormateur() != null) {
				this.setFormateur(new FormateurResponse(formation.getFormateur(),false));
			}
		}
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public GestionnaireResponse getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(GestionnaireResponse gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public List<StagiaireResponse> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<StagiaireResponse> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public List<MatiereParFormationResponse> getMatiereParFormations() {
        return matiereParFormations;
    }

    public void setMatiereParFormations(List<MatiereParFormationResponse> matiereParFormations) {
        this.matiereParFormations = matiereParFormations;
    }

    public FormateurResponse getFormateur() {
        return formateur;
    }

    public void setFormateur(FormateurResponse formateur) {
        this.formateur = formateur;
    }
    
}
