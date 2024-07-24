package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateur;
import com.example.demo.dao.IDAOFormateurMatiere;
import com.example.demo.dao.IDAOFormation;
import com.example.demo.dao.IDAOIndisponibilite;
import com.example.demo.dao.IDAOMatiereParFormation;
import com.example.demo.model.Formateur;
import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.Matiere;

@Service
public class FormateurService {

	@Autowired
	IDAOFormateur daoFormateur;

	@Autowired
	IDAOFormation daoFormation;

	@Autowired
	IDAOFormateurMatiere daoFormateurMatiere;

	@Autowired
	IDAOIndisponibilite daoIndisponibilite;

	@Autowired
	IDAOMatiereParFormation daoMatiereParFormation;

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

	public Formateur getWithFormations(Integer id) {
		Formateur res = this.getById(id);
		res.setFormations(daoFormation.findByFormateur(res));

		return res;
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

	public Formateur getWithMatiereParFormations(Integer id) {
		Formateur res = this.getById(id);
		res.setMatiereParFormation(daoMatiereParFormation.findByFormateur(res));

		return res;
	}

	public List<Formateur> getWithoutMatiere(Matiere matiere) {
		List<Formateur> formateurs = daoFormateur.findAll();
		List<Formateur> formateurRetirer = new ArrayList<Formateur>();
		List<FormateurMatiere> fms = daoFormateurMatiere.findByMatiere(matiere);

		for (FormateurMatiere fm : fms) {
			formateurRetirer.add(fm.getFormateur());
		}

		for (Formateur f : formateurRetirer) {
			formateurs.remove(f);
		}

		return formateurs;
	}

	public Formateur getWithAll(Integer id) {
		Formateur res = this.getById(id);
		res.setFormations(daoFormation.findByFormateur(res));
		res.setFormateurMatieres(daoFormateurMatiere.findByFormateur(res));
		res.setIndisponibilites(daoIndisponibilite.findByFormateur(res));
		res.setMatiereParFormation(daoMatiereParFormation.findByFormateur(res));

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
