package com.example.demo.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Gestionnaire;

public class GestionnaireResponse {

    private Integer id;
	private String lastName;
	private String firstName;
	private String email;
	private String login;
	private String password;

	private List<FormationResponse> formations;
    
    public GestionnaireResponse() {
    }

    public GestionnaireResponse(Gestionnaire gestionnaire, boolean bool) {
        BeanUtils.copyProperties(gestionnaire, this, "formations");
        if (bool) {
            if (gestionnaire.getFormations() != null) {
				this.setFormations(gestionnaire.getFormations().stream()
						.map(formation -> new FormationResponse(formation, false))
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FormationResponse> getFormations() {
        return formations;
    }

    public void setFormations(List<FormationResponse> formations) {
        this.formations = formations;
    }

    
}
