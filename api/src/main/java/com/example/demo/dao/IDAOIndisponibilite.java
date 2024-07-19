package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Formateur;
import com.example.demo.model.Indisponibilite;

public interface IDAOIndisponibilite extends JpaRepository<Indisponibilite, Integer> {

	public List<Indisponibilite> findByFormateur(Formateur formateur);
}
