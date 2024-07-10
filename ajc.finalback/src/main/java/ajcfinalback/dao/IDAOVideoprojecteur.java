package ajcfinalback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ajcfinalback.model.Salle;
import ajcfinalback.model.Videoprojecteur;

public interface IDAOVideoprojecteur extends JpaRepository<Videoprojecteur, Integer> {

	public Videoprojecteur findByMarque(String marque);
	
	public Videoprojecteur findBySalle(Salle salle);

}
