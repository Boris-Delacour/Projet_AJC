package ajcfinalback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ajcfinalback.model.Ordinateur;
import ajcfinalback.model.Stagiaire;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur, Integer> {
	
	public Ordinateur findByMarque(String marque);
	
	public Ordinateur findByOs(String os);
	
	public Ordinateur findByStagiaire(Stagiaire stagiaire);

}
