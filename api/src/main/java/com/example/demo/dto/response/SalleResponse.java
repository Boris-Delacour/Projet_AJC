package com.example.demo.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Salle;
import com.fasterxml.jackson.annotation.JsonView;

public class SalleResponse {
    // @JsonView(CustomJsonViews.Common.class)
    private Integer id;
    // @JsonView(CustomJsonViews.Common.class)
    private Integer numero;
    // @JsonView(CustomJsonViews.Common.class)
    private Integer nbPlace;
    // @JsonView(CustomJsonViews.Common.class)
    private boolean occuper;
    // @JsonView(CustomJsonViews.SalleWithVideoprojecteur.class)
    private VideoprojecteurResponse videoprojecteur;
    // @JsonView(CustomJsonViews.SalleWithAll.class)
    private List<MatiereParFormationResponse> matiereParFormation;

    public SalleResponse() {
    }

    public SalleResponse(Salle Salle) {
        this(Salle, true);
    }

    public SalleResponse(Salle SalleEntity, boolean bool) {
        BeanUtils.copyProperties(SalleEntity, this, "videoprojecteur");
        if (bool) {
            if (SalleEntity.getVideoprojecteur() != null) {
                this.setVideoprojecteur(new VideoprojecteurResponse(SalleEntity.getVideoprojecteur(), false));
            }
            if (SalleEntity.getMatiereParFormation() != null) {
                this.setMatiereParFormation(SalleEntity.getMatiereParFormation().stream()
                        .map(matiereParFormationEntity -> new MatiereParFormationResponse(matiereParFormationEntity,
                                false))
                        .collect(Collectors.toList()));
            }
        }
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

    public VideoprojecteurResponse getVideoprojecteur() {
        return videoprojecteur;
    }

    public void setVideoprojecteur(VideoprojecteurResponse videoprojecteur) {
        this.videoprojecteur = videoprojecteur;
    }

    public List<MatiereParFormationResponse> getMatiereParFormation() {
        return matiereParFormation;
    }

    public void setMatiereParFormation(List<MatiereParFormationResponse> matiereParFormation) {
        this.matiereParFormation = matiereParFormation;
    }

}
