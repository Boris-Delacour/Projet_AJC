package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salle;
import com.example.demo.model.Videoprojecteur;

public interface IDAOSalle extends JpaRepository<Salle, Integer> {

    public List<Salle> findByOccuperTrue();

    public List<Salle> findByOccuperFalse();

	public Salle findByVideoprojecteur(Videoprojecteur videoprojecteur);

}
