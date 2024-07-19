package com.example.demo.dto.response;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Formateur;
import com.example.demo.model.Formation;
import com.example.demo.model.Gestionnaire;
import com.example.demo.model.MatiereParFormation;
import com.example.demo.model.Stagiaire;

public class FormationResponse {

    private Integer id;
	private String nom;
	private LocalDate dateStart;

    private Gestionnaire gestionnaire;
    private List<Stagiaire> stagiaires;
    private List<MatiereParFormation> matiereParFormation;
    private Formateur formateur;

    public FormationResponse() {
    }

    public FormationResponse(Formation formation) {
        BeanUtils.copyProperties(formation, this);
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

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public List<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public List<MatiereParFormation> getMatiereParFormation() {
        return matiereParFormation;
    }

    public void setMatiereParFormation(List<MatiereParFormation> matiereParFormation) {
        this.matiereParFormation = matiereParFormation;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    
}
