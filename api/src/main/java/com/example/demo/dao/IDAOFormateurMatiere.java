package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Formateur;
import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.FormateurMatiereKey;
import com.example.demo.model.Matiere;


public interface IDAOFormateurMatiere extends JpaRepository<FormateurMatiere, FormateurMatiereKey> {

	public List<FormateurMatiere> findByFormateur(Formateur formateur);

	public List<FormateurMatiere> findByMatiere(Matiere matiere);
}
