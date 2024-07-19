package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Stagiaire;

public interface IDAOStagiaire extends JpaRepository<Stagiaire, Integer> {

     //@Query("SELECT s from Stagiaire where s.ordinateur is null")
     //public List<Stagiaire> findAllAvailable();
}
