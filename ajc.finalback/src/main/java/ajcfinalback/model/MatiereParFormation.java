package ajcfinalback.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class MatiereParFormation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate start;
	private LocalDate end;
	
	@ManyToOne
	@JoinColumn(name="matiere")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name="formation")
	private Formation formation;
	@ManyToOne
	@JoinColumn(name="formateur")
	private Formateur formateur;
	@ManyToOne
	@JoinColumn(name="salle")
	private Salle salle;
	
	public MatiereParFormation() {}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public LocalDate getStart() { return start; }
	public void setStart(LocalDate start) { this.start = start; }

	public LocalDate getEnd() { return end; }
	public void setEnd(LocalDate end) { this.end = end; }

	public Matiere getMatiere() { return matiere; }
	public void setMatiere(Matiere matiere) { this.matiere = matiere; }

	public Formation getFormation() { return formation; }
	public void setFormation(Formation formation) { this.formation = formation; }

	public Salle getSalle() { return salle; }
	public void setSalle(Salle salle) { this.salle = salle; }

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
}
