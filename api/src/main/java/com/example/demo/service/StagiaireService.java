package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormation;
import com.example.demo.dao.IDAOOrdinateur;
import com.example.demo.dao.IDAOStagiaire;
import com.example.demo.model.Stagiaire;

@Service
public class StagiaireService {

	@Autowired
	IDAOStagiaire daoStagiaire;

	@Autowired
	IDAOFormation daoFormation;

	@Autowired
	IDAOOrdinateur daoOrdinateur;

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

	public Stagiaire getWithFormation(Integer id) {
		Stagiaire res = this.getById(id);
		res.setFormation(daoFormation.findByStagiaire(res));

		return res;
	}

	public Stagiaire getWithOrdinateur(Integer id) {
		Stagiaire res = this.getById(id);
		res.setOrdinateur(daoOrdinateur.findByStagiaire(res));

		return res;
	}
	
	public Stagiaire getWithAll(Integer id) {
		Stagiaire res = this.getById(id);
		res.setFormation(daoFormation.findByStagiaire(res));
		res.setOrdinateur(daoOrdinateur.findByStagiaire(res));	
		return res;
	}

	public Stagiaire insert(Stagiaire stagiaire) {
		return daoStagiaire.save(stagiaire);
	}

	public Stagiaire update(Stagiaire stagiaire) {
		if (stagiaire.getId() == null) {
			throw new RuntimeException("Impossible d'update une stagiaireService sans id");
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
