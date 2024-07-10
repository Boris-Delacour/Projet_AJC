package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Gestionnaire;
import ajcfinalback.service.GestionnaireService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
class GestionnaireTest {

	@Autowired
	GestionnaireService gestionnaireSrv;
	
	@Test
	void testCrudGestionnaire() {
		Gestionnaire g = new Gestionnaire("John","Doe","bsbsrb","jd","mdp",null);
		Gestionnaire g2 = new Gestionnaire("Jane","Doe","erqgv","jd","mdp",null);
		
		gestionnaireSrv.insert(g);
		gestionnaireSrv.insert(g2);
		
		g = gestionnaireSrv.getById(g.getId());
		
		g2.setFirstName("Kala");
		
		gestionnaireSrv.update(g);
		
		gestionnaireSrv.getAll();
		
		gestionnaireSrv.deleteById(g.getId());
		
		gestionnaireSrv.delete(g2);
	}
}
