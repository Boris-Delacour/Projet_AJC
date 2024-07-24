package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Formateur;
import com.example.demo.model.Formation;
import com.example.demo.model.Gestionnaire;
import com.example.demo.model.MatiereParFormation;
import com.example.demo.model.Stagiaire;

public interface IDAOFormation extends JpaRepository<Formation, Integer> {

	public List<Formation> findByFormateur(Formateur formateur);

	public List<Formation> findByGestionnaire(Gestionnaire gestionnaire);

	@Query("select f from Formation f where f.formateur is null")
	public List<Formation> findWithouFormateur();

	public Formation findByMatiereParFormation(MatiereParFormation matiereParFormation);

	@Query("select f from Formation f where :stagiaire member of f.stagiaires")
	public Formation findByStagiaire(Stagiaire stagiaire);
}
