package ajcfinalback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajcfinalback.dao.IDAOSalle;
import ajcfinalback.dao.IDAOTechnicien;
import ajcfinalback.model.Salle;
import ajcfinalback.model.Technicien;

@Service
public class SalleService {
	@Autowired
	IDAOSalle daoSalle;

	public Salle getById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de find un salle sans id ???");
		}
		Optional<Salle> opt = daoSalle.findById(id);
		if(opt.isPresent()) 
		{
			return opt.get();
		}
		return null;
	}

	public List<Salle> getAll() 
	{
		return daoSalle.findAll();
	}
	


	public Salle insert(Salle salle) 
	{
//		if(stagiaire.getFiliere()==null) 
//		{
//			throw new RuntimeException("Impossible d'insert un stagiaire sans une filiere");
//		}
//		if(stagiaire.getFiliere().getId()==null) 
//		{
//			throw new RuntimeException("Impossible d'insert un stagiaire avec une filiere sans id");
//		}
		return daoSalle.save(salle);
	}

	public Salle update(Salle salle) 
	{
		if(salle.getNumero()==null) 
		{
			throw new RuntimeException("Impossible d'update une salle sans id");
		}
		return daoSalle.save(salle);
	}

	public void deleteById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer une salle sans id ???");
		}
		daoSalle.deleteById(id);
	}

	public void delete(Salle salle) 
	{
		if(salle.getNumero()==null) 
		{
			throw new RuntimeException("Impossible de supprimer une salle sans id ???");
		}
		deleteById(salle.getNumero());
	}
}
