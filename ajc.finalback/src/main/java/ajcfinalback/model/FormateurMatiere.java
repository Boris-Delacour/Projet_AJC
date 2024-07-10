package ajcfinalback.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class FormateurMatiere {

	@EmbeddedId
	private FormateurMatiereKey id;
	@ManyToOne
	@JoinColumn(name = "matiere")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "formateur")
	private Formateur formateur;
}
