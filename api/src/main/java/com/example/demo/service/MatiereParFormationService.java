package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAOFormateur;
import com.example.demo.dao.IDAOFormation;
import com.example.demo.dao.IDAOMatiere;
import com.example.demo.dao.IDAOMatiereParFormation;
import com.example.demo.dao.IDAOSalle;
import com.example.demo.model.MatiereParFormation;
import com.example.demo.model.Salle;

@Service
public class MatiereParFormationService {
	@Autowired
	IDAOMatiereParFormation daoMatiereParFormation;

	@Autowired
	IDAOFormateur daoFormateur;

	@Autowired
	IDAOFormation daoFormation;

	@Autowired
	IDAOMatiere daoMatiere;

	@Autowired
	IDAOSalle daoSalle;

	public MatiereParFormation getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find une matiereParFormation sans id ???");
		}
		Optional<MatiereParFormation> opt = daoMatiereParFormation.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public MatiereParFormation getByIdWithAll(Integer id) {
		MatiereParFormation res = this.getById(id);
		res.setFormateur(daoFormateur.findByMatiereParFormation(res));
		res.setFormation(daoFormation.findByMatiereParFormation(res));
		res.setMatiere(daoMatiere.findByMatieresParFormations(res));
		res.setSalle(daoSalle.findByMatiereParFormation(res));
		return res;
	}

	public List<MatiereParFormation> getAll() {
		return daoMatiereParFormation.findAll();
	}

	public MatiereParFormation insert(MatiereParFormation matiereParFormation) {
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
		return daoMatiereParFormation.save(matiereParFormation);
	}

	public MatiereParFormation update(MatiereParFormation matiereParFormation) {
		if (matiereParFormation.getId() == null) {
			throw new RuntimeException("Impossible d'update une MatiereParFormation sans id");
		}
		return daoMatiereParFormation.save(matiereParFormation);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une MatiereParFormation sans id ???");
		}
		daoMatiereParFormation.deleteById(id);
	}

	public void delete(MatiereParFormation matiereParFormation) {
		if (matiereParFormation.getId() == null) {
			throw new RuntimeException("Impossible de supprimer une MatiereParFormation sans id ???");
		}
		deleteById(matiereParFormation.getId());
	}

}
