package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Matiere;

public interface IDAOMatiere extends JpaRepository<Matiere, Integer> {

}
