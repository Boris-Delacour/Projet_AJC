package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Technicien;

public interface IDAOTechnicien extends JpaRepository<Technicien, Integer> {

}
