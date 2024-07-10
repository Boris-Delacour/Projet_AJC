package ajcfinalback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ajcfinalback.model.FormateurMatiere;
import ajcfinalback.model.FormateurMatiereKey;

public interface IDAOFormateurMatiere extends JpaRepository<FormateurMatiere, FormateurMatiereKey>{

}
