package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Formation;
import com.example.demo.model.Ordinateur;
import com.example.demo.model.Stagiaire;

public interface IDAOStagiaire extends JpaRepository<Stagiaire, Integer> {

     public Stagiaire findByOrdinateur(Ordinateur ordinateur);

    public List<Stagiaire> findByFormation(Formation res);
}
