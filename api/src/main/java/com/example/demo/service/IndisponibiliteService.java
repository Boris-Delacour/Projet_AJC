package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateur;
import com.example.demo.dao.IDAOIndisponibilite;
import com.example.demo.model.Indisponibilite;

@Service
public class IndisponibiliteService {

	@Autowired
	private IDAOIndisponibilite daoIndisponibilite;

	@Autowired
	private IDAOFormateur daoFormateur;

	public List<Indisponibilite> getAll() {
		return daoIndisponibilite.findAll();
	}

	public Indisponibilite getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find une Indisponibilite sans id ???");
		}
		Optional<Indisponibilite> opt = daoIndisponibilite.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Indisponibilite> getAllWithFormateur() {
		List<Indisponibilite> res = this.getAll();
		for (Indisponibilite i : res) {
			i.setFormateur(daoFormateur.findByIndisponibilite(i));
		}

		return res;
	}

	public Indisponibilite getWithFormateur(Integer id) {
		Indisponibilite res = this.getById(id);
		res.setFormateur(daoFormateur.findByIndisponibilite(res));

		return res;
	}

	public Indisponibilite insert(Indisponibilite indisponibilite) {
		return daoIndisponibilite.save(indisponibilite);
	}

	public Indisponibilite update(Indisponibilite indisponibilite) {
		if (indisponibilite.getId() == null) {
			throw new RuntimeException("Impossible d'update une indisponibilite sans id");
		}
		return daoIndisponibilite.save(indisponibilite);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une indisponibilite sans id ???");
		}
		daoIndisponibilite.deleteById(id);
	}

	public void delete(Indisponibilite indisponibilite) {
		this.deleteById(indisponibilite.getId());
	}
}
