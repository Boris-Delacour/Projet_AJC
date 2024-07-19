package com.example.demo.dto.request;

public class OrdinateurRequest {
    private String marque;
    private boolean fonctionnel;
    private String os;
    private Integer idStagiaire;

    public OrdinateurRequest() {
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

    public Integer getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(Integer idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

}
