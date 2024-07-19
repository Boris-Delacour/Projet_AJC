package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOVideoprojecteur;
import com.example.demo.model.Ordinateur;
import com.example.demo.model.Salle;
import com.example.demo.model.Videoprojecteur;

@Service
public class VideoprojecteurService {
	@Autowired
	IDAOVideoprojecteur daoVideoprojecteur;

	public Videoprojecteur getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un videoprojecteur sans id ???");
		}
		Optional<Videoprojecteur> opt = daoVideoprojecteur.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Videoprojecteur> getByMarque(String marque) {
		return daoVideoprojecteur.findByMarque(marque);
	}

	public List<Videoprojecteur> getByFonctionnelTrue() {
		return daoVideoprojecteur.findByFonctionnelTrue();
	}

	public List<Videoprojecteur> getByFonctionnelFalse() {
		return daoVideoprojecteur.findByFonctionnelFalse();
	}

	public Videoprojecteur getBySalle(Salle salle) {
		return daoVideoprojecteur.findBySalle(salle);
	}

	public List<Videoprojecteur> getAll() {
		return daoVideoprojecteur.findAll();
	}

	public Videoprojecteur insert(Videoprojecteur videoprojecteur) {
		return daoVideoprojecteur.save(videoprojecteur);
	}

	public Videoprojecteur update(Videoprojecteur videoprojecteur) {
		if (videoprojecteur.getId() == null) {
			throw new RuntimeException("Impossible d'update une videoprojecteur sans id");
		}
		return daoVideoprojecteur.save(videoprojecteur);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une videoprojecteur sans id ???");
		}
		daoVideoprojecteur.deleteById(id);
	}

	public void delete(Videoprojecteur videoprojecteur) {
		if (videoprojecteur.getId() == null) {
			throw new RuntimeException("Impossible de supprimer une videoprojecteur sans id ???");
		}
		deleteById(videoprojecteur.getId());
	}

}
