package com.example.demo.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Matiere;
import com.fasterxml.jackson.annotation.JsonView;

public class MatiereResponse {

	@JsonView(CustomJsonViews.Common.class)
	private Integer id;
	@JsonView(CustomJsonViews.Common.class)
	private String libelle;
	@JsonView(CustomJsonViews.Common.class)
	private Integer duration;
	@JsonView(CustomJsonViews.Common.class)
	private String objective;
	@JsonView(CustomJsonViews.Common.class)
	private String prerequisite;
	@JsonView(CustomJsonViews.Common.class)
	private String content;

	@JsonView(CustomJsonViews.MatiereWithFormateur.class)
	private List<FormateurResponse> formateurs;

	@JsonView(CustomJsonViews.MatiereWithMatiereParFormation.class)
	private List<MatiereParFormationResponse> matiereParFormations;

	public MatiereResponse() {
	}

	public MatiereResponse(Matiere matiere) {
		this(matiere, false);
	}

	public MatiereResponse(Matiere matiere, boolean bool) {
		BeanUtils.copyProperties(matiere, this);
		if(bool) {
			if(matiere.getFormateurMatieres() != null) {
				this.setFormateurs(matiere.getFormateurMatieres().stream()
						.map(formateur -> new FormateurResponse(formateur.getFormateur()))
						.collect(Collectors.toList()));
			}
			if(matiere.getMatieresParFormations() != null) {
				this.setMatiereParFormations(matiere.getMatieresParFormations().stream()
						.map(matiereParFormation -> new MatiereParFormationResponse(matiereParFormation))
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

	public List<FormateurResponse> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<FormateurResponse> formateurs) {
		this.formateurs = formateurs;
	}

	public List<MatiereParFormationResponse> getMatiereParFormations() {
		return matiereParFormations;
	}

	public void setMatiereParFormations(List<MatiereParFormationResponse> matiereParFormations) {
		this.matiereParFormations = matiereParFormations;
	}
}
