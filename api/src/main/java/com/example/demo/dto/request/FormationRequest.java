package com.example.demo.dto.request;

import java.time.LocalDate;

import com.example.demo.model.Gestionnaire;

public class FormationRequest {

	private String nom;
	private LocalDate dateStart;

    private Integer idGestionnaire;
    private Integer idFormateur;
    
    public FormationRequest() {
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

    public Integer getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Integer getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(Integer idFormateur) {
        this.idFormateur = idFormateur;
    }

    
}
