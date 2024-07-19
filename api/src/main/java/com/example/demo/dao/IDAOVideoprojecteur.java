package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salle;
import com.example.demo.model.Videoprojecteur;

public interface IDAOVideoprojecteur extends JpaRepository<Videoprojecteur, Integer> {

	public Videoprojecteur findByMarque(String marque);

	public Videoprojecteur findBySalle(Salle salle);

}
