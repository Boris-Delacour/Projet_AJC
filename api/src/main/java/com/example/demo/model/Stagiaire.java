package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stagiaire")
public class Stagiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;

	@ManyToOne
	@JoinColumn(name = "formation")
	private Formation formation;
	@OneToOne
	@JoinColumn(name = "ordinateur", nullable = true)
	private Ordinateur ordinateur;

	public Stagiaire() {
	}

	public Stagiaire(Integer id, String firstName, String lastName, String email,
			Formation formation) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.formation = formation;
	}

	public Stagiaire(String firstName, String lastName, String email,
			Formation formation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.formation = formation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", login=" + "formation=" + formation + "]";
	}

}
