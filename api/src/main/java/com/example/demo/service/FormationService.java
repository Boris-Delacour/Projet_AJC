package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateur;
import com.example.demo.dao.IDAOFormation;
import com.example.demo.dao.IDAOGestionnaire;
import com.example.demo.model.Formation;

@Service
public class FormationService {
	@Autowired
	IDAOFormation daoFormation;

	@Autowired
	IDAOFormateur daoFormateur;

	@Autowired
	IDAOGestionnaire daoGestionnaire;

	public Formation getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un Formation sans id ???");
		}
		Optional<Formation> opt = daoFormation.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Formation getWithFormateurs(Integer id) {
		Formation res = this.getById(id);
		res.setFormateur(daoFormateur.findByFormation(res));

		return res;
	}

	public Formation getWithGestionnaires(Integer id) {
		Formation res = this.getById(id);
		res.setGestionnaire(daoGestionnaire.findByFormation(res));

		return res;
	}

	public List<Formation> getAll() {
		return daoFormation.findAll();
	}

	public Formation insert(Formation formation) {
		return daoFormation.save(formation);
	}

	public Formation update(Formation formation) {
		if (formation.getId() == null) {
			throw new RuntimeException("Impossible d'update un formation sans id");
		}
		return daoFormation.save(formation);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer un formation sans id ???");
		}
		daoFormation.deleteById(id);
	}

	public void delete(Formation formation) {
		if (formation.getId() == null) {
			throw new RuntimeException("Impossible de supprimer un formation sans id ???");
		}
		deleteById(formation.getId());
	}
}
