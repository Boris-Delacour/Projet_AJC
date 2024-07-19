package com.example.demo.dto.request;

public class StagiaireRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	
	private Integer idFormation;
	
	public StagiaireRequest() {

	}
	
	
	public Integer getIdFormation() {
		return idFormation;
	}


	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
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

	
}
