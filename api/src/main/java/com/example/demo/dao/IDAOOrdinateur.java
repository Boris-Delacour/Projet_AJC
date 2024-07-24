package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Ordinateur;
import com.example.demo.model.Stagiaire;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur, Integer> {

	public List<Ordinateur> findByMarque(String marque);

	public List<Ordinateur> findByOs(String os);

	public List<Ordinateur> findByFonctionnelTrue();

	public List<Ordinateur> findByFonctionnelFalse();

	public Ordinateur findByStagiaire(Stagiaire stagiaire);
	
	 @Query("SELECT o FROM Ordinateur o WHERE o.stagiaire IS NULL AND o.fonctionnel = true")
	    List<Ordinateur> findAvailableAndFonctionnel();

}
