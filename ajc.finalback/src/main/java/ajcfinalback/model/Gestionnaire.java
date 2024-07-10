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
@Table(name = "gestionnaire")
public class Gestionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String lastName;
	private String firstName;
	private String email;
	private String login;
	private String password;
	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.LAZY)
	private List<Formation> formations;
	
	
	public Gestionnaire() {
		
	}

	public Gestionnaire(String lastName, String firstName, String email, String login, String password,
			List<Formation> formations) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.formations = formations;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	
	
}
