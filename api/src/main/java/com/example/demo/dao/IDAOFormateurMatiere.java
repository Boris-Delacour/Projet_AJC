package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.FormateurMatiereKey;

public interface IDAOFormateurMatiere extends JpaRepository<FormateurMatiere, FormateurMatiereKey> {

}
