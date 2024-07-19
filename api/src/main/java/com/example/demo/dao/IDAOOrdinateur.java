package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ordinateur;
import com.example.demo.model.Stagiaire;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur, Integer> {

	public List<Ordinateur> findByMarque(String marque);

	public List<Ordinateur> findByOs(String os);

	public Ordinateur findByStagiaire(Stagiaire stagiaire);

}
