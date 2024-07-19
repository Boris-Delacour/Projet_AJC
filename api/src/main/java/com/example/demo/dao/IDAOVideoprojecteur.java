package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salle;
import com.example.demo.model.Videoprojecteur;

public interface IDAOVideoprojecteur extends JpaRepository<Videoprojecteur, Integer> {

	public List<Videoprojecteur> findByMarque(String marque);

	public Videoprojecteur findBySalle(Salle salle);

}
