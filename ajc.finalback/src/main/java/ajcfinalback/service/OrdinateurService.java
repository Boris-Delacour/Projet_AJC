package ajcfinalback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajcfinalback.dao.IDAOOrdinateur;
import ajcfinalback.model.Ordinateur;

@Service
public class OrdinateurService {
	@Autowired
	IDAOOrdinateur daoOrdinateur;

	public Ordinateur getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de find un stagiaire sans id ???");
		}
		Optional<Ordinateur> opt = daoOrdinateur.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public List<Ordinateur> getAll() {
		return daoOrdinateur.findAll();
	}

	public Ordinateur insert(Ordinateur ordinateur) {
		return daoOrdinateur.save(ordinateur);
	}

	public Ordinateur update(Ordinateur ordinateur) {
		if (ordinateur.getId() == null) {
			throw new RuntimeException("Impossible d'update une ordinateur sans id");
		}
		return daoOrdinateur.save(ordinateur);
	}

	public void deleteById(Integer id) {
		if (id == null) {
			throw new RuntimeException("Impossible de supprimer une ordinateur sans id ???");
		}
		daoOrdinateur.deleteById(id);
	}

	public void delete(Ordinateur ordinateur) {
		if (ordinateur.getId() == null) {
			throw new RuntimeException("Impossible de supprimer une ordinateur sans id ???");
		}
		deleteById(ordinateur.getId());
	}

}
