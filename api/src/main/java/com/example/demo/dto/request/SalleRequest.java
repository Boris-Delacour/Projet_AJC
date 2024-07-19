package com.example.demo.dto.request;

public class SalleRequest {
    private Integer id;
    private Integer numero;
    private Integer nbPlace;
    private boolean occuper;
    private Integer idVideoprojecteur;

    public SalleRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Integer getIdVideoprojecteur() {
        return idVideoprojecteur;
    }

    public void setIdVideoprojecteur(Integer idVideoprojecteur) {
        this.idVideoprojecteur = idVideoprojecteur;
    }

}
