package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Formation;

public interface IDAOFormation extends JpaRepository<Formation, Integer> {

}
