package ajcfinalback.model;

import java.time.LocalDate;

public class MatiereParFormation {

	private Integer id;
	private LocalDate start;
	private LocalDate end;
	
	private Matiere matiere;
	private Formation formation;
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
	
}
