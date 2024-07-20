package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Formateur;
import com.example.demo.model.MatiereParFormation;


public interface IDAOMatiereParFormation extends JpaRepository<MatiereParFormation, Integer> {

	public List<MatiereParFormation> findByFormateur(Formateur formateur);
}
