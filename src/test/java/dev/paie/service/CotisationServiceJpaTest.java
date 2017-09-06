package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Cotisation;
import dev.paie.spring.JpaConfig;

//TODO compléter la configuration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JpaConfig.class })
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Before

	public void init() {
		cotisationService.truncate();

	}

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via
		// laméthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// lister

		Cotisation cotisation1 = new Cotisation();
		cotisation1.setCode("EP01");
		cotisation1.setLibelle("URSSAF MALADIE - MATERNITE - INVALIDITE");
		cotisation1.setTauxSalarial(new BigDecimal("0.0075"));
		cotisation1.setTauxPatronal(new BigDecimal("0.1280"));
		cotisationService.sauvegarder(cotisation1);

		Cotisation cotisation2 = new Cotisation();
		cotisation2.setCode("EP05");
		cotisation2.setLibelle("URSSAF ASS. VIEILLESSE PLAF");
		cotisation2.setTauxSalarial(new BigDecimal("0.0675"));
		cotisation2.setTauxPatronal(new BigDecimal("0.0840"));
		cotisationService.sauvegarder(cotisation2);

		List<Cotisation> cotisationList = cotisationService.lister();
		cotisation1 = cotisationList.get(0);
		System.out.println(cotisation2);
		System.out.println(cotisationList);
		assertTrue(cotisationList.contains(cotisation1));
		assertTrue(cotisationList.contains(cotisation2));

		// cotisation2.setCode("EP03");
		cotisation1.setLibelle("URSSAF ACCIDENT DU TRAVAIL");
		cotisation1.setTauxPatronal(new BigDecimal("0.0120"));
		cotisation1.setTauxSalarial(new BigDecimal("0.0840"));
		cotisationService.mettreAJour(cotisation1);
		
		List<Cotisation> cotisationList2 = cotisationService.lister();
		System.out.println(cotisationList2);
		
		assertEquals(0.012000, cotisation1.getTauxPatronal().doubleValue(), 0.0001);
		assertEquals(0.084000, cotisation1.getTauxSalarial().doubleValue(), 0.0001);
	}

	/**
	 * @return the cotisationService
	 */
	public CotisationService getCotisationService() {
		return cotisationService;
	}

	/**
	 * @param cotisationService
	 *            the cotisationService to set
	 */
	public void setCotisationService(CotisationService cotisationService) {
		this.cotisationService = cotisationService;
	}
}
