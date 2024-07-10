package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Technicien;
import ajcfinalback.service.TechnicienService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
class TechnicienTest {

	@Autowired
	TechnicienService tSrv;
	
	@Test
	void testInsertUpdate() {
		Technicien t = new Technicien("John","Doe","bsbsrb","jd","mdp");
		Technicien t2 = new Technicien("Jane","Doe","bsbsrb","jd","mdp");
		
		tSrv.insert(t);
		tSrv.insert(t2);
		
		t = tSrv.getById(t.getId());
		
		t.setFirstName("Tarzan");
		
		tSrv.update(t);
		
		tSrv.getAll();
		
		tSrv.deleteById(t.getId());
		
		tSrv.delete(t2);
		
	}
	
}
