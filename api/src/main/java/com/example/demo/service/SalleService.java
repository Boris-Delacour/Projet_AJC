package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOSalle;
import com.example.demo.model.Salle;

@Service
public class SalleService {
	@Autowired
	IDAOSalle daoSalle;

	public Salle getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un salle sans id ???");
		}
		Optional<Salle> opt = daoSalle.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Salle> getByOccuperTrue() {
		return daoSalle.findByOccuperTrue();
	}

	public List<Salle> getByOccuperFalse() {
		return daoSalle.findByOccuperFalse();
	}

	public List<Salle> getAll() {
		return daoSalle.findAll();
	}

	public Salle insert(Salle salle) {
		// if(stagiaire.getFiliere()==null)
		// {
		// throw new RuntimeException("Impossible d'insert un stagiaire sans une
		// filiere");
		// }
		// if(stagiaire.getFiliere().getId()==null)
		// {
		// throw new RuntimeException("Impossible d'insert un stagiaire avec une filiere
		// sans id");
		// }
		return daoSalle.save(salle);
	}

	public Salle update(Salle salle) {
		if (salle.getNumero() == null) {
			throw new RuntimeException("Impossible d'update une salle sans id");
		}
		return daoSalle.save(salle);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une salle sans id ???");
		}
		daoSalle.deleteById(id);
	}

	public void delete(Salle salle) {
		if (salle.getNumero() == null) {
			throw new RuntimeException("Impossible de supprimer une salle sans id ???");
		}
		deleteById(salle.getNumero());
	}
}
