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
@Table(name = "formateur")
public class Formateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String lastname;
	private String firstname;
	private String email;
	private String login;
	private String password;

	@OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY)
	private List<Formation> formations;

	@OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY)
	private List<Indisponibilite> indisponibilites;

	@OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY)
	private List<FormateurMatiere> formateurMatieres;

	@OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY)
	private List<MatiereParFormation> matiereParFormation;
	
	public Formateur() {}
	
	public Formateur(String lastname, String firstname, String email, String login, String password) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getLastname() { return lastname; }
	public void setLastname(String lastname) { this.lastname = lastname; }

	public String getFirstname() { return firstname; }
	public void setFirstname(String firstname) { this.firstname = firstname; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getLogin() { return login; }
	public void setLogin(String login) { this.login = login; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	public List<Indisponibilite> getIndisponibilites() { return indisponibilites; }
	public void setIndisponibilites(List<Indisponibilite> indisponibilites) { this.indisponibilites = indisponibilites; }

	public List<FormateurMatiere> getFormateurMatieres() {
		return formateurMatieres;
	}

	public void setFormateurMatieres(List<FormateurMatiere> formateurMatieres) {
		this.formateurMatieres = formateurMatieres;
	}

	public List<MatiereParFormation> getMatiereParFormation() { return matiereParFormation; }
	public void setMatiereParFormation(List<MatiereParFormation> matiereParFormation) { this.matiereParFormation = matiereParFormation; }
	
}
