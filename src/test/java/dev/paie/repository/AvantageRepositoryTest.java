package dev.paie.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.spring.JpaConfig;

//TODO compléter la configuration

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class })
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage

		Avantage avantage1 = new Avantage();
		avantage1.setCode("code001");
		avantage1.setNom("freed");
		avantage1.setMontant(123);
		avantage1.

		Avantage avantage2 = new Avantage();
		avantage1.setCode("code002");
		avantage1.setNom("grteet");
		avantage1.setMontant(56);

		Avantage avantage3 = new Avantage();
		avantage1.setCode("code003");
		avantage1.setNom("htrdezz");
		avantage1.setMontant(778);

		Avantage avantage4 = new Avantage();
		avantage1.setCode("code004");
		avantage1.setNom("kieet");
		avantage1.setMontant(79);

		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la
		// méthode findOne
		// TODO modifier un avantage
		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// findOne
	}

	/**
	 * @return the avantageRepository
	 */
	public AvantageRepository getAvantageRepository() {
		return avantageRepository;
	}

	/**
	 * @param avantageRepository
	 *            the avantageRepository to set
	 */
	public void setAvantageRepository(AvantageRepository avantageRepository) {
		this.avantageRepository = avantageRepository;
	}
}