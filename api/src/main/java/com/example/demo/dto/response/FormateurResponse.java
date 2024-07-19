package com.example.demo.dto.response;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Formateur;
import com.fasterxml.jackson.annotation.JsonView;

public class FormateurResponse {

    private Integer id;
	private String lastname;
	private String firstname;
	private String email;
	private String login;
	private String password;
	
	//
    
    public FormateurResponse() {

    }
    

    public FormateurResponse(Formateur formateur, boolean bool) {
        BeanUtils.copyProperties(formateur, this);
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

    

}
