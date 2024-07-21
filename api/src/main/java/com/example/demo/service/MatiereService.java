package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateurMatiere;
import com.example.demo.dao.IDAOMatiere;
import com.example.demo.dao.IDAOMatiereParFormation;
import com.example.demo.model.Matiere;

@Service
public class MatiereService {

	@Autowired
	IDAOMatiere daoMatiere;

	@Autowired 
	IDAOFormateurMatiere daoFormateurMatiere;

	@Autowired 
	IDAOMatiereParFormation daoMatiereParFormation;

	public Matiere getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find une matiere sans id ???");
		}
		Optional<Matiere> opt = daoMatiere.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Matiere> getAll() {
		return daoMatiere.findAll();
	}

	public Matiere getWithFormateurs(Integer id) {
		Matiere res = this.getById(id);
		res.setFormateurMatieres(daoFormateurMatiere.findByMatiere(res));

		return res;
	}

	public Matiere getWithMatiereParFormation(Integer id) {
		Matiere res = this.getById(id);
		res.setMatieresParFormations(daoMatiereParFormation.findByMatiere(res));

		return res;
	}

	public Matiere insert(Matiere matiere) {
		return daoMatiere.save(matiere);
	}

	public Matiere update(Matiere matiere) {
		if (matiere.getId() == null) {
			throw new RuntimeException("Impossible d'update une matiere sans id");
		}
		return daoMatiere.save(matiere);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une matiere sans id ???");
		}
		daoMatiere.deleteById(id);
	}

	public void delete(Matiere matiere) {
		if (matiere.getId() == null) {
			throw new RuntimeException("Impossible de supprimer une matiere sans id ???");
		}
		deleteById(matiere.getId());
	}
}
