package ajcfinalback.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Formateur;
import ajcfinalback.model.FormateurMatiere;
import ajcfinalback.model.Matiere;
import ajcfinalback.service.FormateurMatiereService;
import ajcfinalback.service.FormateurService;
import ajcfinalback.service.MatiereService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class FormateurTest {

	@Autowired
	FormateurService fSrv;
	
	@Autowired
	MatiereService mSrv;
	
	@BeforeEach
	void msg() {
		System.out.println("Nouveau Test");
		System.out.println("");
	}
	
	@Test
	void testCrudFormateur() {
		Formateur f = new Formateur("John","Doe","bsbsrb","jd","mdp");
		Formateur f2 = new Formateur("Jane","Doe","bsbsrb","jd","mdp");
		
		fSrv.insert(f);
		fSrv.insert(f2);
		
		f = fSrv.getById(f.getId());
		
		f.setFirstname("Tarzan");
		
		fSrv.update(f);
		
		fSrv.getAll();
		
		fSrv.deleteById(f.getId());
		
		fSrv.delete(f2);
	}
	
	@Test
	void testCrudMatiere() {
		Matiere m = new Matiere("Java Avance", 3, "Apprendre Java", "Connaitre les bases de Java", "Les fonctions avancé de Java");
		Matiere m2 = new Matiere("Java BDD", 3, "Apprenddre a lier Java a une BDD", "Maitriser Java Avancer", "JDBC et JPA");
		
		mSrv.insert(m);
		mSrv.insert(m2);
		
		m = mSrv.getById(m.getId());
		
		m.setLibelle("Java Fonction Avancée");
		
		mSrv.update(m);
		
		mSrv.getAll();
		
		mSrv.deleteById(m.getId());
		
		mSrv.delete(m2);
	}
	
}
