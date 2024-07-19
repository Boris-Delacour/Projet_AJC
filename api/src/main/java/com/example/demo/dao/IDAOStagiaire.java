package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Stagiaire;

public interface IDAOStagiaire extends JpaRepository<Stagiaire, Integer> {

    // @Query("SELECT s from Stagiaire where s.ordinateur is null")
    // public List<Stagiaire> findAllAvailable();
}
