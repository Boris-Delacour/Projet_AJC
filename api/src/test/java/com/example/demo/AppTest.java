package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Formateur;
import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.Formation;
import com.example.demo.model.Gestionnaire;
import com.example.demo.model.Matiere;
import com.example.demo.model.MatiereParFormation;
import com.example.demo.model.Ordinateur;
import com.example.demo.model.Salle;
import com.example.demo.model.Stagiaire;
import com.example.demo.model.Technicien;
import com.example.demo.model.Videoprojecteur;
import com.example.demo.service.FormateurMatiereService;
import com.example.demo.service.FormateurService;
import com.example.demo.service.FormationService;
import com.example.demo.service.GestionnaireService;
import com.example.demo.service.MatiereParFormationService;
import com.example.demo.service.MatiereService;
import com.example.demo.service.OrdinateurService;
import com.example.demo.service.SalleService;
import com.example.demo.service.StagiaireService;
import com.example.demo.service.TechnicienService;
import com.example.demo.service.VideoprojecteurService;

@SpringBootTest
@Transactional
@Rollback
class AppTest {
	@Autowired
	FormateurService fSrv;
	@Autowired
	MatiereService mSrv;
	@Autowired
	FormateurMatiereService fmSrv;
	@Autowired
	FormationService foSrv;
	@Autowired
	GestionnaireService gSrv;
	@Autowired
	MatiereParFormationService mpfSrv;
	@Autowired
	OrdinateurService oSrv;
	@Autowired
	SalleService sSrv;
	@Autowired
	StagiaireService stSrv;
	@Autowired
	TechnicienService tSrv;
	@Autowired
	VideoprojecteurService vpSrv;

	@BeforeEach
	void msg() {
		System.out.println("Nouveau Test");
		System.out.println("");
	}

	@Test
	void testCrudFormateur() {
		Formateur f = new Formateur("John", "Doe", "bsbsrb", "jd", "mdp");
		Formateur f2 = new Formateur("Jane", "Doe", "bsbsrb", "jd", "mdp");

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
		Matiere m = new Matiere("Java Avance", 3, "Apprendre Java", "Connaitre les bases de Java",
				"Les fonctions avancé de Java");
		Matiere m2 = new Matiere("Java BDD", 3, "Apprenddre a lier Java a une BDD", "Maitriser Java Avancer",
				"JDBC et JPA");

		mSrv.insert(m);
		mSrv.insert(m2);

		m = mSrv.getById(m.getId());

		m.setLibelle("Java Fonction Avancée");

		mSrv.update(m);
		mSrv.getAll();
		mSrv.deleteById(m.getId());
		mSrv.delete(m2);
	}

	@Test
	void testCrudFormateurMatiere() {
		Formateur f = new Formateur("John", "Doe", "bsbsrb", "jd", "mdp");
		Formateur f2 = new Formateur("Jane", "Doe", "bsbsrb", "jd", "mdp");
		Matiere m = new Matiere("Java Avance", 3, "Apprendre Java", "Connaitre les bases de Java",
				"Les fonctions avancé de Java");
		Matiere m2 = new Matiere("Java BDD", 3, "Apprenddre a lier Java a une BDD", "Maitriser Java Avancer",
				"JDBC et JPA");

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

		FormateurMatiere fm3 = fmSrv.insert(fm);
		fmSrv.insert(fm2);

		assertNotNull(fmSrv.getById(fm3.getId()));
		fm = fmSrv.getById(fm3.getId());
		fm.setMatiere(m2);

		fmSrv.update(fm);
		fmSrv.getAll();
		fmSrv.deleteById(fm.getId());
		fmSrv.delete(fm2);
	}

	@Test
	void testCrudFormation() {
		Formation f = new Formation("Spring", LocalDate.now(), null, null, null, null);
		Formation f2 = new Formation("Angular", LocalDate.now(), null, null, null, null);

		foSrv.insert(f);
		foSrv.insert(f2);

		f = foSrv.getById(f.getId());

		f.setNom("Hibernate");

		foSrv.update(f);
		foSrv.getAll();
		foSrv.deleteById(f.getId());
		foSrv.delete(f2);
	}

	@Test
	void testCrudGestionnaire() {
		Gestionnaire g = new Gestionnaire("John", "Doe", "bsbsrb", "jd", "mdp", null);
		Gestionnaire g2 = new Gestionnaire("Jane", "Doe", "erqgv", "jd", "mdp", null);

		gSrv.insert(g);
		gSrv.insert(g2);

		g = gSrv.getById(g.getId());
		g2.setFirstName("Kala");

		gSrv.update(g);
		gSrv.getAll();
		gSrv.deleteById(g.getId());
		gSrv.delete(g2);
	}

	@Test
	void testCrudMatiereParFormation() {
		MatiereParFormation t = new MatiereParFormation();
		MatiereParFormation t2 = new MatiereParFormation();

		mpfSrv.insert(t);
		mpfSrv.insert(t2);

		t = mpfSrv.getById(t.getId());

		mpfSrv.update(t);
		mpfSrv.getAll();
		mpfSrv.deleteById(t.getId());
		mpfSrv.delete(t2);
	}

	@Test
	void testCrudOrdinateur() {
		Ordinateur t = new Ordinateur("asus", true, "Windows", null);
		Ordinateur t2 = new Ordinateur("MSI", true, "Linux", null);

		oSrv.insert(t);
		oSrv.insert(t2);

		t = oSrv.getById(t.getId());
		List<Ordinateur> ordis = oSrv.getByMarque(t.getMarque());
		List<Ordinateur> ordi2s = oSrv.getByOs(t.getOs());

		t.setFonctionnel(false);
		;

		oSrv.update(t);
		oSrv.getAll();
		oSrv.deleteById(t.getId());
		oSrv.delete(t2);
	}

	@Test
	void testCrudSalle() {
		Salle s = new Salle(1, 24, false, null, null);
		Salle s2 = new Salle(2, 25, true, null, null);

		sSrv.insert(s);
		sSrv.insert(s2);

		s = sSrv.getById(s.getId());

		sSrv.update(s);
		sSrv.getAll();
		sSrv.deleteById(s.getId());
		sSrv.delete(s2);
	}

	@Test
	void testCrudStagiaire() {
		Stagiaire s = new Stagiaire("John", "Cena", "wololo", "cenation", "test", null);
		Stagiaire s2 = new Stagiaire("Johnny", "Hallyday", "wololo", "allumer", "lefeu", null);
		Formation f = new Formation("formation", LocalDate.now(), null, null, null, null);

		s = stSrv.insert(s);
		stSrv.insert(s2);

		s = stSrv.getById(s.getId());
		s.setFirstName("Waylon");

		foSrv.insert(f);
		s.setFormation(f);
		stSrv.update(s);
		stSrv.getAll();
		stSrv.deleteById(s.getId());
		stSrv.delete(s2);
	}

	@Test
	void testCrudTechnicien() {
		Technicien t = new Technicien("John", "Doe", "bsbsrb", "jd", "mdp");
		Technicien t2 = new Technicien("Jane", "Doe", "bsbsrb", "jd", "mdp");

		tSrv.insert(t);
		tSrv.insert(t2);

		t = tSrv.getById(t.getId());
		t.setFirstName("Tarzan");

		tSrv.update(t);
		tSrv.getAll();
		tSrv.deleteById(t.getId());
		tSrv.delete(t2);
	}

	@Test
	void testCrudVideoprojecteur() {
		Videoprojecteur v = new Videoprojecteur("Toshiba", true, null);
		Videoprojecteur v2 = new Videoprojecteur("Sony", true, null);

		vpSrv.insert(v);
		vpSrv.insert(v2);

		v = vpSrv.getById(v.getId());
		List<Videoprojecteur> vs = vpSrv.getByMarque(v.getMarque());
		v.setFonctionnel(false);
		;

		vpSrv.update(v);
		vpSrv.getAll();
		vpSrv.deleteById(v.getId());
		vpSrv.delete(v2);
	}
}
