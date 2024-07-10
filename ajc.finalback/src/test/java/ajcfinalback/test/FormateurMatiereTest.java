package ajcfinalback.test;

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
public class FormateurMatiereTest {

	@Autowired
	FormateurService fSrv;
	
	@Autowired
	MatiereService mSrv;
	
	@Autowired
	FormateurMatiereService fmSrv;
	
	@Test
	void testCrudFormateurMatiere() {
		Formateur f = new Formateur("John","Doe","bsbsrb","jd","mdp");
		Formateur f2 = new Formateur("Jane","Doe","bsbsrb","jd","mdp");
		Matiere m = new Matiere("Java Avance", 3, "Apprendre Java", "Connaitre les bases de Java", "Les fonctions avancé de Java");
		Matiere m2 = new Matiere("Java BDD", 3, "Apprenddre a lier Java a une BDD", "Maitriser Java Avancer", "JDBC et JPA");
		
		fSrv.insert(f);
		fSrv.insert(f2);
		mSrv.insert(m);
		mSrv.insert(m2);
		
		m = mSrv.getById(m.getId());
		m2 = mSrv.getById(m2.getId());
		f = fSrv.getById(f.getId());
		f2 = fSrv.getById(f2.getId());
		
		FormateurMatiere fm = new FormateurMatiere(m, f);
		FormateurMatiere fm2 = new FormateurMatiere(m2, f2);
		
		fmSrv.insert(fm);
		fmSrv.insert(fm2);
		
		fm = fmSrv.getById(fm.getId());
		
		fm.setMatiere(m2);
		
		fmSrv.update(fm);
		
		fmSrv.getAll();
		
		fmSrv.deleteById(fm.getId());
		
		fmSrv.delete(fm2);
		
	}
}
