package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Stagiaire;
import com.fasterxml.jackson.annotation.JsonView;

public class StagiaireResponse {

	@JsonView(CustomJsonViews.Common.class)
	private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private String firstName;
	@JsonView(CustomJsonViews.Common.class)
	private String lastName;
	@JsonView(CustomJsonViews.Common.class)
	private String email;

	@JsonView(CustomJsonViews.StagiaireWithAll.class)
	private FormationResponse formation;

	@JsonView(CustomJsonViews.StagiaireWithAll.class)
	private OrdinateurResponse ordinateur;

	public StagiaireResponse() {

	}

	public StagiaireResponse(Stagiaire stagiaire) {
		this(stagiaire, true);
	}

	public StagiaireResponse(Stagiaire stagiaire, boolean bool) {
		BeanUtils.copyProperties(stagiaire, this, "formation, ordinateur");
		if (bool) {
			if (stagiaire.getFormation() != null) {
				this.setFormation(new FormationResponse(stagiaire.getFormation()));
			}
			if (stagiaire.getOrdinateur() != null) {
				this.setOrdinateur(new OrdinateurResponse(stagiaire.getOrdinateur()));
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public FormationResponse getFormation() {
		return formation;
	}

	public void setFormation(FormationResponse formation) {
		this.formation = formation;
	}

	public OrdinateurResponse getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(OrdinateurResponse ordinateur) {
		this.ordinateur = ordinateur;
	}
}
