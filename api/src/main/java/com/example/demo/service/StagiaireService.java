package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOStagiaire;
import com.example.demo.model.Stagiaire;

@Service
public class StagiaireService {

	@Autowired
	IDAOStagiaire daoStagiaire;

	public Stagiaire getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un stagiaire sans id ???");
		}
		Optional<Stagiaire> opt = daoStagiaire.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Stagiaire> getAll() {
		return daoStagiaire.findAll();
	}

	// public List<Stagiaire> getAllAvailable()
	// {
	// return daoStagiaire.findAllAvailable();
	// }

	public Stagiaire insert(Stagiaire stagiaire) {
		return daoStagiaire.save(stagiaire);
	}

	public Stagiaire update(Stagiaire stagiaire) {
		if (stagiaire.getId() == null) {
			throw new RuntimeException("Impossible d'update une stagiaireService sans id");
		}
		if (stagiaire.getFormation() == null) {
			throw new RuntimeException("Impossible d'update un stagiaireService sans une formation");
		}
		if (stagiaire.getFormation().getId() == null) {
			throw new RuntimeException("Impossible d'update un stagiaireService avec une formation sans id");
		}
		return daoStagiaire.save(stagiaire);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une stagiaireService sans id ???");
		}
		daoStagiaire.deleteById(id);
	}

	public void delete(Stagiaire stagiaire) {
		if (stagiaire.getId() == null) {
			throw new RuntimeException("Impossible de supprimer une stagiaireService sans id ???");
		}
		deleteById(stagiaire.getId());
	}
}