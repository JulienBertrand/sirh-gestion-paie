package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

//TODO compléter la configuration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Before
	public void init() {
		gradeService.truncate();

	}

	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		Grade grade1 = new Grade();
		grade1.setCode("F001");
		grade1.setNbHeuresBase(new BigDecimal("37.3"));
		grade1.setTauxBase(new BigDecimal("1.1"));
		gradeService.sauvegarder(grade1);

		 Grade grade2 = new Grade();
		 grade2.setCode("F436");
		 grade2.setNbHeuresBase(new BigDecimal("38.3"));
		 grade2.setTauxBase(new BigDecimal("8.45"));
		 gradeService.sauvegarder(grade2);

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode
		List<Grade> lister1 = gradeService.lister();
		System.out.println(lister1);
		assertTrue(lister1.contains(grade1));
		assertTrue(lister1.contains(grade2));

		// lister
		// TODO modifier un grade
		
		
		grade2.setNbHeuresBase(new BigDecimal("49.6"));
		grade2.setTauxBase(new BigDecimal("4.6"));		
		
		gradeService.mettreAJour(grade2);
		List<Grade> lister2=gradeService.lister();
		
		System.out.println(lister2);
		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		
		assertEquals(49.6, grade2.getNbHeuresBase().doubleValue(), 2);
		assertEquals(4.6, grade2.getTauxBase().doubleValue(), 2);
		// lister

	}

	/**
	 * @return the gradeService
	 */
	public GradeService getGradeService() {
		return gradeService;
	}

	/**
	 * @param gradeService
	 *            the gradeService to set
	 */
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
}