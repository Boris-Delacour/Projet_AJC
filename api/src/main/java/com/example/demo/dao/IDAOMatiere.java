package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Matiere;
import com.example.demo.model.MatiereParFormation;

public interface IDAOMatiere extends JpaRepository<Matiere, Integer> {

    public Matiere findByMatieresParFormations(MatiereParFormation matiereParFormation);

}
