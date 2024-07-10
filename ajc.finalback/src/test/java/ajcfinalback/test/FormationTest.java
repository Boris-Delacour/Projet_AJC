package ajcfinalback.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Formation;
import ajcfinalback.service.FormationService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
class FormationTest {

	@Autowired
	FormationService formationSrv;
	
	@Test
	void testFormation() {
		Formation f = new Formation("Spring",LocalDate.now(),null,null,null,null);
		Formation f2 = new Formation("Angular",LocalDate.now(),null,null,null,null);
		
		formationSrv.insert(f);
		formationSrv.insert(f2);
		
		f = formationSrv.getById(f.getId());
		
		f.setNom("Hibernate");
		
		formationSrv.update(f);
		
		formationSrv.getAll();
		
		formationSrv.deleteById(f.getId());
		
		formationSrv.delete(f2);
	}
}
