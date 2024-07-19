package com.example.demo.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Formateur;
import com.fasterxml.jackson.annotation.JsonView;

public class FormateurResponse {

	@JsonView(CustomJsonViews.Common.class)
    private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private String lastname;
	@JsonView(CustomJsonViews.Common.class)
	private String firstname;
	@JsonView(CustomJsonViews.Common.class)
	private String email;
	@JsonView(CustomJsonViews.Common.class)
	private String login;
	@JsonView(CustomJsonViews.Common.class)
	private String password;

	@JsonView(CustomJsonViews.FormateurWithMatiere.class)
	private List<MatiereResponse> matieres;
    
    public FormateurResponse() {

    }

	public FormateurResponse(Formateur formateur) {
        this(formateur, false);
    }

    public FormateurResponse(Formateur formateur, Boolean bool) {
        BeanUtils.copyProperties(formateur, this, "formations, indisponibilites, formateurMatiere, matiereParFormation");
		if(bool) {
			if (formateur.getFormateurMatieres() != null) {
				this.setMatieres(formateur.getFormateurMatieres().stream()
						.map(matiere -> new MatiereResponse(matiere.getMatiere()))
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

	public List<MatiereResponse> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<MatiereResponse> matieres) {
		this.matieres = matieres;
	}

    

}
