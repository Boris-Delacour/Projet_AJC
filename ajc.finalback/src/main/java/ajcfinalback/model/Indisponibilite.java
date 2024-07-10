package ajcfinalback.model;

import java.time.LocalDate;

public class Indisponibilite {
	
	private LocalDate start;
	private LocalDate end;
	
	private Formateur formateur;

	public Indisponibilite() {}

	public LocalDate getStart() { return start; }
	public void setStart(LocalDate start) { this.start = start; }

	public LocalDate getEnd() { return end; }
	public void setEnd(LocalDate end) { this.end = end; }

	public Formateur getFormateur() { return formateur; }
	public void setFormateur(Formateur formateur) { this.formateur = formateur; }
	
}
