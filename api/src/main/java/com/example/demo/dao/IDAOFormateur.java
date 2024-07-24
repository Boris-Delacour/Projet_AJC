package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Formateur;
import com.example.demo.model.Formation;
import com.example.demo.model.Indisponibilite;
import com.example.demo.model.MatiereParFormation;

public interface IDAOFormateur extends JpaRepository<Formateur, Integer> {

    @Query("Select f from Formateur f Where :formation member of f.formations")
    public Formateur findByFormation(Formation formation);

    @Query("select f from Formateur f where :indisponibilite member of f.indisponibilites")
    public Formateur findByIndisponibilite(Indisponibilite indisponibilite);

    public Formateur findByMatiereParFormation(MatiereParFormation matiereParFormation);
}
