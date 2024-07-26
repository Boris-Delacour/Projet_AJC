package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Role;
import com.example.demo.model.Utilisateur;
import java.util.Optional;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByUsername(String username);

    @Query("select u from Utilisateur u where :role like u.role AND :idRole = u.idRole")
    Optional<Utilisateur> findByRoleAndIdRole(Role role, Integer idRole);
}
