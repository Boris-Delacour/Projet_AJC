package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOTechnicien;
import com.example.demo.model.Technicien;

@Service
public class TechnicienService {
	@Autowired
	IDAOTechnicien daoTechnicien;

	public Technicien getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un technicienService sans id ???");
		}
		Optional<Technicien> opt = daoTechnicien.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Technicien> getAll() {
		return daoTechnicien.findAll();
	}

	public Technicien insert(Technicien technicien) {
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
		return daoTechnicien.save(technicien);
	}

	public Technicien update(Technicien technicien) {
		if (technicien.getId() == null) {
			throw new RuntimeException("Impossible d'update une technicienService sans id");
		}
		return daoTechnicien.save(technicien);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une technicienService sans id ???");
		}
		daoTechnicien.deleteById(id);
	}

	public void delete(Technicien technicien) {
		if (technicien.getId() == null) {
			throw new RuntimeException("Impossible de supprimer une technicienService sans id ???");
		}
		deleteById(technicien.getId());
	}
}
