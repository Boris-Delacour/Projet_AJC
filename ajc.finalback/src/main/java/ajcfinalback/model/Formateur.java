package ajcfinalback.model;

import java.util.List;

public class Formateur {

	private Integer id;
	private String lastname;
	private String firstname;
	private String email;
	private String login;
	private String password;

	private Formation formation;
	private List<Indisponibilite> indisponibilites;
	private List<Matiere> matieres;
	private List<MatiereParFormation> matiereParFormation;
	
	public Formateur() {}

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

	public Formation getFormation() { return formation; }
	public void setFormation(Formation formation) { this.formation = formation; }

	public List<Indisponibilite> getIndisponibilites() { return indisponibilites; }
	public void setIndisponibilites(List<Indisponibilite> indisponibilites) { this.indisponibilites = indisponibilites; }

	public List<Matiere> getMatieres() { return matieres; }
	public void setMatieres(List<Matiere> matieres) { this.matieres = matieres; }

	public List<MatiereParFormation> getMatiereParFormation() { return matiereParFormation; }
	public void setMatiereParFormation(List<MatiereParFormation> matiereParFormation) { this.matiereParFormation = matiereParFormation; }
	
}
