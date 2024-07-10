package ajcfinalback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ajcfinalback.model.Ordinateur;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur, Integer> {

}
