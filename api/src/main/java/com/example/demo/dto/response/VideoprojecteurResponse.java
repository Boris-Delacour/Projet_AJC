package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Videoprojecteur;
import com.fasterxml.jackson.annotation.JsonView;

public class VideoprojecteurResponse {
    // @JsonView(CustomJsonViews.Common.class)
    private Integer id;
    // @JsonView(CustomJsonViews.Common.class)
    private String marque;
    // @JsonView(CustomJsonViews.Common.class)
    private boolean fonctionnel;
    // @JsonView(CustomJsonViews.VideoprojecteurWithSalle.class)
    private SalleResponse salle;

    public VideoprojecteurResponse() {
    }

    public VideoprojecteurResponse(Videoprojecteur Videoprojecteur) {
        this(Videoprojecteur, true);
    }

    public VideoprojecteurResponse(Videoprojecteur VideoprojecteurEntity, boolean bool) {
        BeanUtils.copyProperties(VideoprojecteurEntity, this, "stagiaire");
        if (bool) {
            if (VideoprojecteurEntity.getSalle() != null) {
                this.setSalle(new SalleResponse(VideoprojecteurEntity.getSalle(), false));
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

    public SalleResponse getSalle() {
        return salle;
    }

    public void setSalle(SalleResponse salle) {
        this.salle = salle;
    }

}
