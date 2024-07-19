package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateurMatiere;
import com.example.demo.model.Formateur;
import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.FormateurMatiereKey;
import com.example.demo.model.Matiere;

@Service
public class FormateurMatiereService {

	@Autowired
	IDAOFormateurMatiere daoFormateurMatiere;

	public FormateurMatiere getById(FormateurMatiereKey id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un formateurMatiere sans id ???");
		}
		Optional<FormateurMatiere> opt = daoFormateurMatiere.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<FormateurMatiere> getByFormateur(Formateur formateur) {
		if(formateur.getId() == null) {
			throw new RuntimeException("Impossible de find une liste de formateurMatiere via formateur_id sans l'id du formateur");
		}

		return daoFormateurMatiere.findByFormateur(formateur);
	}

	public List<FormateurMatiere> getByMatieres(Matiere matiere) {
		if(matiere.getId() == null) {
			throw new RuntimeException("Impossible de find une liste de formateurMatiere via matiere_id sans l'id de la matiere");
		}

		return daoFormateurMatiere.findByMatiere(matiere);
	}

	public List<FormateurMatiere> getAll() {
		return daoFormateurMatiere.findAll();
	}

	public FormateurMatiere insert(FormateurMatiere formateurMatiere) {
		return daoFormateurMatiere.save(formateurMatiere);
	}

	public FormateurMatiere update(FormateurMatiere formateurMatiere) {
		if (formateurMatiere.getId() == null) {
			throw new RuntimeException("Impossible d'update un formateurMatiere sans id");
		}
		return daoFormateurMatiere.save(formateurMatiere);
	}

	public void deleteById(FormateurMatiereKey id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer un formateurMatiere sans id ???");
		}
		daoFormateurMatiere.deleteById(id);
	}

	public void delete(FormateurMatiere formateurMatiere) {
		if (formateurMatiere.getId() == null) {
			throw new RuntimeException("Impossible de supprimer un formateurMatiere sans id ???");
		}
		deleteById(formateurMatiere.getId());
	}
}
