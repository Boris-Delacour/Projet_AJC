package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Stagiaire;

public class StagiaireResponse {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private FormateurResponse formateur;
	
	public StagiaireResponse() {

	}

	public StagiaireResponse(Stagiaire stagiaire) {
		this(stagiaire, true);
	}

	public StagiaireResponse(Stagiaire stagiaireModel, boolean bool) {
		BeanUtils.copyProperties(stagiaireModel, this, "formateur");
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

	public FormateurResponse getFormateur() {
		return formateur;
	}

	public void setFormateur(FormateurResponse formateur) {
		this.formateur = formateur;
	}
	
	

}
