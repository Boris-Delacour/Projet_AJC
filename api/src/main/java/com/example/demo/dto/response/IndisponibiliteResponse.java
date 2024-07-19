package com.example.demo.dto.response;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Indisponibilite;
import com.fasterxml.jackson.annotation.JsonView;

public class IndisponibiliteResponse {

	@JsonView(CustomJsonViews.Common.class)
	private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private LocalDate start;
	@JsonView(CustomJsonViews.Common.class)
	private LocalDate end;

	public IndisponibiliteResponse() {
	}

	public IndisponibiliteResponse(Indisponibilite indisponibilite) {
		BeanUtils.copyProperties(indisponibilite, this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
