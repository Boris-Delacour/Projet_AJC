package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOUtilisateur;
import com.example.demo.exceptions.UtilisateurException;
import com.example.demo.model.Role;
import com.example.demo.model.Utilisateur;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    IDAOUtilisateur daoUtilisateur;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return daoUtilisateur.findByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("Utilisateur inconnu");
        });
    }

    public Utilisateur getById(Integer id) {
        if (id == null) {
            throw new RuntimeException("Impossible de find un formateur sans id ???");
        }
        Optional<Utilisateur> opt = daoUtilisateur.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public Utilisateur getByUsername(String username) {
        if (username == null) {
            throw new RuntimeException("Impossible de find un formateur sans id ???");
        }
        Optional<Utilisateur> opt = daoUtilisateur.findByUsername(username);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public Utilisateur create(Utilisateur utilisateur, Role role) {
        if (utilisateur.getUsername() == null || utilisateur.getUsername().isBlank()
                || daoUtilisateur.findByUsername(utilisateur.getUsername()).isPresent()) {
            throw new UtilisateurException("Probleme d'identifiant");
        }

        if (utilisateur.getPassword() == null || utilisateur.getPassword().isBlank()) {
            throw new UtilisateurException("Probleme de mot de passe");
        }
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRole(role);
        return daoUtilisateur.save(utilisateur);
    }
}
