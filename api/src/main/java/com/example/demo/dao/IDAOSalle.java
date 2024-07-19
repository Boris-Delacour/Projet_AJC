package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salle;

public interface IDAOSalle extends JpaRepository<Salle, Integer> {

}
