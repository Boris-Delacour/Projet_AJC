package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Ordinateur;
import com.fasterxml.jackson.annotation.JsonView;

public class OrdinateurResponse {
    @JsonView(CustomJsonViews.Common.class)
    private Integer id;
    @JsonView(CustomJsonViews.Common.class)
    private String marque;
    @JsonView(CustomJsonViews.Common.class)
    private boolean fonctionnel;
    @JsonView(CustomJsonViews.Common.class)
    private String os;
    @JsonView(CustomJsonViews.OrdinateurWithStagiaire.class)
    private StagiaireResponse stagiaire;

    public OrdinateurResponse() {
    }

    public OrdinateurResponse(Ordinateur Ordinateur) {
        this(Ordinateur, true);
    }

    public OrdinateurResponse(Ordinateur OrdinateurEntity, boolean bool) {
        BeanUtils.copyProperties(OrdinateurEntity, this, "stagiaire");
        if (bool) {
            if (OrdinateurEntity.getStagiaire() != null) {
                this.setStagiaire(new StagiaireResponse(OrdinateurEntity.getStagiaire(), false));
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StagiaireResponse getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(StagiaireResponse stagiaire) {
        this.stagiaire = stagiaire;
    }

}
