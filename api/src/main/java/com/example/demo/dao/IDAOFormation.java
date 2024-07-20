package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Formateur;
import com.example.demo.model.Formation;


public interface IDAOFormation extends JpaRepository<Formation, Integer> {

	public List<Formation> findByFormateur(Formateur formateur);
}
