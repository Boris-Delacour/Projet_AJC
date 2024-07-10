package ajcfinalback.model;

import java.util.List;

public class Matiere {

	private Integer id;
	private String libelle;
	private Integer duration;
	private String objective;
	private String prerequisite;
	private String content;
	
	private List<Formateur> formateurs;
	
	private List<MatiereParFormation> matieresParFormations;

	public Matiere() {}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }

	public Integer getDuration() { return duration; }
	public void setDuration(Integer duration) { this.duration = duration; }

	public String getObjective() { return objective; }
	public void setObjective(String objective) { this.objective = objective; }

	public String getPrerequisite() { return prerequisite; }
	public void setPrerequisite(String prerequisite) { this.prerequisite = prerequisite; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	public List<Formateur> getFormateurs() { return formateurs; }
	public void setFormateurs(List<Formateur> formateurs) { this.formateurs = formateurs; }

	public List<MatiereParFormation> getMatieresParFormations() { return matieresParFormations; }
	public void setMatieresParFormations(List<MatiereParFormation> matieresParFormations) { this.matieresParFormations = matieresParFormations; }
	
}
