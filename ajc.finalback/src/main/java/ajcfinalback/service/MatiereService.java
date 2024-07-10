package ajcfinalback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajcfinalback.dao.IDAOMatiere;
import ajcfinalback.model.Matiere;

@Service
public class MatiereService {
	
	@Autowired
	IDAOMatiere daoMatiere;

	public Matiere getById(Integer id) {
		if(id==null) {
			throw new RuntimeException("Impossible de find une matiere sans id ???");
		}
		Optional<Matiere> opt = daoMatiere.findById(id);
		if(opt.isPresent()) { return opt.get(); }
		return null;
	}

	public List<Matiere> getAll() {
		return daoMatiere.findAll();
	}
	


	public Matiere insert(Matiere matiere) {
		return daoMatiere.save(matiere);
	}

	public Matiere update(Matiere matiere) {
		if(matiere.getId()==null) {
			throw new RuntimeException("Impossible d'update une matiere sans id");
		}
		return daoMatiere.save(matiere);
	}

	public void deleteById(Integer id) {
		if(id==null) {
			throw new RuntimeException("Impossible de supprimer une matiere sans id ???");
		}
		daoMatiere.deleteById(id);
	}

	public void delete(Matiere matiere) {
		if(matiere.getId()==null) {
			throw new RuntimeException("Impossible de supprimer une matiere sans id ???");
		}
		deleteById(matiere.getId());
	}
}
