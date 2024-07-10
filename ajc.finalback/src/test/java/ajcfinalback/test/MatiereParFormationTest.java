package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ajcfinalback.model.MatiereParFormation;
import ajcfinalback.model.Technicien;
import ajcfinalback.service.MatiereParFormationService;
import ajcfinalback.service.TechnicienService;

public class MatiereParFormationTest {
	@Autowired
	MatiereParFormationService tSrv;
	
	@Test
	void testInsertUpdate() {
		MatiereParFormation t = new MatiereParFormation();
		MatiereParFormation t2 = new MatiereParFormation();
		
		tSrv.insert(t);
		tSrv.insert(t2);
		
		t = tSrv.getById(t.getId());
		
		tSrv.update(t);
		
		tSrv.getAll();
		
		tSrv.deleteById(t.getId());
		
		tSrv.delete(t2);
		
	}
}
