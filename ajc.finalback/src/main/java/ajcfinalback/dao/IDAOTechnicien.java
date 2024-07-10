package ajcfinalback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajcfinalback.model.Technicien;

public interface IDAOTechnicien extends JpaRepository<Technicien,Integer> {

}
