package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Technicien;
import com.fasterxml.jackson.annotation.JsonView;

public class TechnicienResponse {

	@JsonView(CustomJsonViews.Common.class)
	private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private String firstName;
	@JsonView(CustomJsonViews.Common.class)
	private String lastName;
	@JsonView(CustomJsonViews.Common.class)
	private String email;

	public TechnicienResponse() {

	}

	public TechnicienResponse(Technicien technicien) {
		BeanUtils.copyProperties(technicien, this);
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

}
