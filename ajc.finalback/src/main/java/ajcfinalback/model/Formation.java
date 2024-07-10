package ajcfinalback.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private LocalDate dateStart;
	
	@ManyToOne
	@JoinColumn(name="gestionnaire")
	private Gestionnaire gestionnaire;
	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private List<Stagiaire> stagiaires;
	@OneToMany(mappedBy = "formation")
	private List<MatiereParFormation> matiereParFormation;
	@ManyToOne
	@JoinColumn(name="referent")
	private Formateur formateur;
	
	
	public Formation() {
		
	}

	public Formation(String nom, LocalDate dateStart, Gestionnaire gestionnaire, List<Stagiaire> stagiaires,
			List<MatiereParFormation> matiereParFormation, Formateur formateur) {
		this.nom = nom;
		this.dateStart = dateStart;
		this.gestionnaire = gestionnaire;
		this.stagiaires = stagiaires;
		this.matiereParFormation = matiereParFormation;
		this.formateur = formateur;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public LocalDate getDateStart() {
		return dateStart;
	}


	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}


	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}


	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}


	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}


	public List<MatiereParFormation> getMatiereParFormation() {
		return matiereParFormation;
	}


	public void setMatiereParFormation(List<MatiereParFormation> matiereParFormation) {
		this.matiereParFormation = matiereParFormation;
	}


	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	
	
}
