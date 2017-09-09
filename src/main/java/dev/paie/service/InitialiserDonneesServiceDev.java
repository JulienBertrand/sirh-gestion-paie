package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import dev.paie.entite.Avantage;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Configuration
// Import de la configuration XML dans une configuration Java
@ImportResource({ "classpath:cotisations-imposables.xml", "classpath:cotisations-non-imposables.xml",
		"classpath:entreprises.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml" })
@ComponentScan({ "dev" })
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	// @Autowired
	// private AvantageRepository avantageRepository;
//	@Autowired
//	private BulletinSalaireRepository bulletinSalalireRepository;
	@Autowired
	private CotisationRepository cotisationRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;

	// @Autowired
	// private List<Avantage> avantages;
//	@Autowired
//	private List<BulletinSalaire> bulletinSalaires;
	@Autowired
	private List<Cotisation> cotisations;
	@Autowired
	private List<Entreprise> entreprises;
	@Autowired
	private List<Grade> grades;
	// @Autowired
	// private List<Periode> periodes;
	@Autowired
	private List<ProfilRemuneration> profilRemunerations;
	// @Autowired
	// private List<RemunerationEmploye> remunerationEmployes;

	@Override
	public void initialiser() {
		// TODO Auto-generated method stub
		// for (Avantage avantage : avantages) {
		// avantageRepository.save(avantage);
		// }
		for (Cotisation cotisation : cotisations) {
			cotisationRepository.save(cotisation);
		}
		for (Entreprise entreprise : entreprises) {
			entrepriseRepository.save(entreprise);
		}
		for (Grade grade : grades) {
			gradeRepository.save(grade);
		}
		for (int i = 1; i <= 12; i++) {
			periodeRepository.save(new Periode(i));
		}
		for (ProfilRemuneration profilRemuneration : profilRemunerations) {
			profilRemunerationRepository.save(profilRemuneration);
		}
		// for (RemunerationEmploye remunerationEmploye : remunerationEmployes) {
		// remunerationEmployeRepository.save(remunerationEmploye);
		// }
//		for (BulletinSalaire bulletinSalaire : bulletinSalaires) {
//		bulletinSalalireRepository.save(bulletinSalaire);
//		}
	}

}
