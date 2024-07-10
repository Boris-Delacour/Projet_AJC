package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ajcfinalback.config.AppConfig;
import ajcfinalback.model.Videoprojecteur;
import ajcfinalback.service.VideoprojecteurService;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class VideoprojecteurTest {

	@Autowired
	VideoprojecteurService vpSrv;
	
	@Test
	void testInsertUpdate() {
		Videoprojecteur t = new Videoprojecteur("Toshiba", true, null);
		Videoprojecteur t2 = new Videoprojecteur("Sony", true, null);
		
		vpSrv.insert(t);
		vpSrv.insert(t2);
		
		t = vpSrv.getById(t.getId());
		
		t.setFonctionnel(false);;
		
		vpSrv.update(t);
		
		vpSrv.getAll();
		
		vpSrv.deleteById(t.getId());
		
		vpSrv.delete(t2);
		
	}

}
