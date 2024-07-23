package com.example.demo.dto.request;

import java.time.LocalDate;

public class IndisponibiliteRequest {

	private LocalDate start;
	private LocalDate end;

	private Integer formateur;

	public IndisponibiliteRequest() {
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Integer getFormateur() {
		return formateur;
	}

	public void setFormateur(Integer formateur) {
		this.formateur = formateur;
	}
}
