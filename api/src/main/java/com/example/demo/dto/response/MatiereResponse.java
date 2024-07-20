package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Matiere;

public class MatiereResponse {

	private Integer id;
	private String libelle;
	private Integer duration;
	private String objective;
	private String prerequisite;
	private String content;

	public MatiereResponse() {
	}

	public MatiereResponse(Matiere matiere) {
		this(matiere, false);
	}

	public MatiereResponse(Matiere matiere, boolean bool) {
		BeanUtils.copyProperties(matiere, this);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}
