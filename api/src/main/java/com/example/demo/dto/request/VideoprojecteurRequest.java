package com.example.demo.dto.request;

public class VideoprojecteurRequest {
    private String marque;
    private boolean fonctionnel;
    private Integer idSalle;

    public VideoprojecteurRequest() {
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

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

}
