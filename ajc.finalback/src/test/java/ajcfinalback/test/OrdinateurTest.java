package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Ordinateur;
import ajcfinalback.service.OrdinateurService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class OrdinateurTest {

	@Autowired
	OrdinateurService oSrv;
	
	@Test
	void testInsertUpdate() {
		Ordinateur t = new Ordinateur("asus", true, "Windows", null);
		Ordinateur t2 = new Ordinateur("MSI", true, "Linux", null);
		
		oSrv.insert(t);
		oSrv.insert(t2);
		
		t = oSrv.getById(t.getId());
		
		t.setFonctionnel(false);;
		
		oSrv.update(t);
		
		oSrv.getAll();
		
		oSrv.deleteById(t.getId());
		
		oSrv.delete(t2);
		
	}

}
