package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Stagiaire;
import ajcfinalback.service.StagiaireService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
class StagiaireTest {

	@Autowired
	StagiaireService sSrv;
	
	@Test
	void testInsertUpdate() {
		Stagiaire s = new Stagiaire("John","Cena","wololo","cenation","test",null);
		Stagiaire s1 = new Stagiaire("Johnny","Hallyday","wololo","allumer","lefeu",null);
		
		sSrv.insert(s);
		sSrv.insert(s1);
		
		s = sSrv.getById(s.getId());
		
		s.setFirstName("Waylon");
		
		sSrv.update(s);
		
		sSrv.getAll();
		
		sSrv.deleteById(s.getId());
		
		sSrv.delete(s1);
	}
}
