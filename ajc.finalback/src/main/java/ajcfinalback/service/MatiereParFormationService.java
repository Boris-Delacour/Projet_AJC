package ajcfinalback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ajcfinalback.dao.IDAOMatiereParFormation;
import ajcfinalback.model.MatiereParFormation;

public class MatiereParFormationService {
	@Autowired
	IDAOMatiereParFormation daoMatiereParFormation;

	public MatiereParFormation getById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de find une matiereParFormation sans id ???");
		}
		Optional<MatiereParFormation> opt = daoMatiereParFormation.findById(id);
		if(opt.isPresent()) 
		{
			return opt.get();
		}
		return null;
	}

	public List<MatiereParFormation> getAll() 
	{
		return daoMatiereParFormation.findAll();
	}
	


	public MatiereParFormation insert(MatiereParFormation matiereParFormation) 
	{
//		if(stagiaire.getFiliere()==null) 
//		{
//			throw new RuntimeException("Impossible d'insert un stagiaire sans une filiere");
//		}
//		if(stagiaire.getFiliere().getId()==null) 
//		{
//			throw new RuntimeException("Impossible d'insert un stagiaire avec une filiere sans id");
//		}
		return daoMatiereParFormation.save(matiereParFormation);
	}

	public MatiereParFormation update(MatiereParFormation matiereParFormation) 
	{
		if(matiereParFormation.getId()==null) 
		{
			throw new RuntimeException("Impossible d'update une MatiereParFormation sans id");
		}
		return daoMatiereParFormation.save(matiereParFormation);
	}

	public void deleteById(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer une MatiereParFormation sans id ???");
		}
		daoMatiereParFormation.deleteById(id);
	}

	public void delete(MatiereParFormation matiereParFormation) 
	{
		if(matiereParFormation.getId()==null) 
		{
			throw new RuntimeException("Impossible de supprimer une MatiereParFormation sans id ???");
		}
		deleteById(matiereParFormation.getId());
	}
}
