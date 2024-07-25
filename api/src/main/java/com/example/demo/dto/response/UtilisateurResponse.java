package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonView;

public class UtilisateurResponse {

    @JsonView(CustomJsonViews.Common.class)
    private Integer id;
    @JsonView(CustomJsonViews.Common.class)
    private String username;
    @JsonView(CustomJsonViews.Common.class)
    private String role;
    @JsonView(CustomJsonViews.Common.class)
    private Integer idRole;

    public UtilisateurResponse() {
    }

    public UtilisateurResponse(Utilisateur utilisateur) {
        BeanUtils.copyProperties(utilisateur, this, "role");
        this.role = utilisateur.getRole().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
}
