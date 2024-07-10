package ajcfinalback.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "matiere")
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	private Integer duration;
	private String objective;
	private String prerequisite;
	private String content;
	
	@OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY)
	private List<FormateurMatiere> formateurMatieres;
	
	@OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY)
	private List<MatiereParFormation> matieresParFormations;

	public Matiere() {}

	public Matiere(String libelle, Integer duration, String objective, String prerequisite, String content) {
		this.libelle = libelle;
		this.duration = duration;
		this.objective = objective;
		this.prerequisite = prerequisite;
		this.content = content;
	}

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

	
	public List<FormateurMatiere> getFormateurMatieres() {
		return formateurMatieres;
	}

	public void setFormateurMatieres(List<FormateurMatiere> formateurMatieres) {
		this.formateurMatieres = formateurMatieres;
	}

	public List<MatiereParFormation> getMatieresParFormations() { return matieresParFormations; }
	public void setMatieresParFormations(List<MatiereParFormation> matieresParFormations) { this.matieresParFormations = matieresParFormations; }
	
}
