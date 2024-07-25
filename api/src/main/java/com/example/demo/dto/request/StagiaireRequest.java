package com.example.demo.dto.request;

public class StagiaireRequest {

	private String firstName;
	private String lastName;
	private String email;

	private Integer idFormation;

	private Integer idOrdinateur;

	public StagiaireRequest() {

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

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	public Integer getIdOrdinateur() {
		return idOrdinateur;
	}

	public void setIdOrdinateur(Integer idOrdinateur) {
		this.idOrdinateur = idOrdinateur;
	}

}
