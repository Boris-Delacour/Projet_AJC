package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateur;
import com.example.demo.dao.IDAOFormateurMatiere;
import com.example.demo.dao.IDAOIndisponibilite;
import com.example.demo.model.Formateur;

@Service
public class FormateurService {

	@Autowired
	IDAOFormateur daoFormateur;

	@Autowired 
	IDAOFormateurMatiere daoFormateurMatiere;

	@Autowired 
	IDAOIndisponibilite daoIndisponibilite;

	public Formateur getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un formateur sans id ???");
		}
		Optional<Formateur> opt = daoFormateur.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Formateur getWithMatieres(Integer id) {
		Formateur res = this.getById(id);
		res.setFormateurMatieres(daoFormateurMatiere.findByFormateur(res));

		return res;
	}

	public Formateur getWithIndisponibilite(Integer id) {
		Formateur res = this.getById(id);
		res.setIndisponibilites(daoIndisponibilite.findByFormateur(res));

		return res;
	}

	public List<Formateur> getAll() {
		return daoFormateur.findAll();
	}

	public Formateur insert(Formateur formateur) {
		return daoFormateur.save(formateur);
	}

	public Formateur update(Formateur formateur) {
		if (formateur.getId() == null) {
			throw new RuntimeException("Impossible d'update un formateur sans id");
		}
		return daoFormateur.save(formateur);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer un formateur sans id ???");
		}
		daoFormateur.deleteById(id);
	}

	public void delete(Formateur formateur) {
		if (formateur.getId() == null) {
			throw new RuntimeException("Impossible de supprimer un formateur sans id ???");
		}
		deleteById(formateur.getId());
	}
}
