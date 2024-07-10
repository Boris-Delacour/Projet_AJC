package ajcfinalback.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;


@Entity
public class FormateurMatiere {

	@EmbeddedId
	private FormateurMatiereKey id = new FormateurMatiereKey();
	
	@ManyToOne
	@MapsId("matiereId")
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;
	
	@ManyToOne
	@MapsId("formateurId")
	@JoinColumn(name = "formateur_id")
	private Formateur formateur;
	
	public FormateurMatiere() {}
	
	public FormateurMatiere(Matiere matiere, Formateur formateur) {
		this.matiere = matiere;
		this.formateur = formateur;
	}
	
	public FormateurMatiereKey getId() { return id; }
	public void setId(FormateurMatiereKey id) { this.id = id; }
	
	public Matiere getMatiere() { return matiere; }
	public void setMatiere(Matiere matiere) { this.matiere = matiere; }
	
	public Formateur getFormateur() { return formateur; }
	public void setFormateur(Formateur formateur) { this.formateur = formateur; }
	
	
}
