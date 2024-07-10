package ajcfinalback.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ajcfinalback.model.Salle;
import ajcfinalback.model.Technicien;
import ajcfinalback.service.SalleService;
import ajcfinalback.service.TechnicienService;

public class SalleTest {
	@Autowired
	SalleService tSrv;
	
	@Test
	void testInsertUpdate() {
		Salle t = new Salle(1,24,false,null,null);
		Salle t2 = new Salle(2,25,true,null,null);
		
		tSrv.insert(t);
		tSrv.insert(t2);
		
		t = tSrv.getById(t.getNumero());
		
		tSrv.update(t);
		
		tSrv.getAll();
		
		tSrv.deleteById(t.getNumero());
		
		tSrv.delete(t2);
		
	}
}
