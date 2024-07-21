package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Formation;
import com.example.demo.model.Gestionnaire;

public interface IDAOGestionnaire extends JpaRepository<Gestionnaire, Integer> {

    @Query("Select f from Gestionnaire f Where :formation member of f.formations")
    public Gestionnaire findByFormation(Formation formation);
}
