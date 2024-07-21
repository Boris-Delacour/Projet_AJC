package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormation;
import com.example.demo.dao.IDAOGestionnaire;
import com.example.demo.model.Formateur;
import com.example.demo.model.Gestionnaire;

@Service
public class GestionnaireService {
	@Autowired
	IDAOGestionnaire daoGestionnaire;

	@Autowired
	IDAOFormation daoFormation;

	public Gestionnaire getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un Gestionnaire sans id ???");
		}
		Optional<Gestionnaire> opt = daoGestionnaire.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Gestionnaire getWithFormations(Integer id) {
		Gestionnaire res = this.getById(id);
		res.setFormations(daoFormation.findByGestionnaire(res));

		return res;
	}

	public List<Gestionnaire> getAll() {
		return daoGestionnaire.findAll();
	}

	public Gestionnaire insert(Gestionnaire gestionnaire) {
		return daoGestionnaire.save(gestionnaire);
	}

	public Gestionnaire update(Gestionnaire gestionnaire) {
		if (gestionnaire.getId() == null) {
			throw new RuntimeException("Impossible d'update un gestionnaire sans id");
		}
		return daoGestionnaire.save(gestionnaire);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer un gestionnaire sans id ???");
		}
		daoGestionnaire.deleteById(id);
	}

	public void delete(Gestionnaire gestionnaire) {
		if (gestionnaire.getId() == null) {
			throw new RuntimeException("Impossible de supprimer un gestionnaire sans id ???");
		}
		deleteById(gestionnaire.getId());
	}

}
