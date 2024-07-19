package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ordinateur;
import com.example.demo.model.Stagiaire;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur, Integer> {

	public Ordinateur findByMarque(String marque);

	public Ordinateur findByOs(String os);

	public Ordinateur findByStagiaire(Stagiaire stagiaire);

}
