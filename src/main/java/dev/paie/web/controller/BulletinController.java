package dev.paie.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/bulletins")
@Transactional // Ajout pour eviter le lazy initialyze et le chargement de l'arrayList pour le
				// calcul des salaires
public class BulletinController {

	@Autowired
	PeriodeRepository periodeRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;
	@Autowired
	CalculerRemunerationServiceSimple calculerRemunerationServicesimple;

	@RequestMapping(method = RequestMethod.GET, path = "/creer_bulletin")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();

		BigDecimal primeExceptionnelle = null;

		mv.setViewName("bulletins/creer_bulletin");
		mv.addObject("periodes", periodeRepository.findAll());
		mv.addObject("remunerationEmployes", remunerationEmployeRepository.findAll());
		mv.addObject("primeExceptionnelles", primeExceptionnelle);

		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer_bulletin")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// utilisation des "sets"

		BulletinSalaire bulletinSalaire = new BulletinSalaire();

		bulletinSalaire.setPeriode(periodeRepository.findOne(Integer.parseInt(request.getParameter("periodeId"))));
		bulletinSalaire.setRemunerationEmploye(
				remunerationEmployeRepository.findOne(Integer.parseInt(request.getParameter("remunerationEmployeId"))));
		bulletinSalaire.setPrimeExceptionnelle(
				new BigDecimal(Double.parseDouble(request.getParameter("primeExceptionnelle"))));

		bulletinSalaireRepository.save(bulletinSalaire);

		return new ModelAndView("redirect:" + "/mvc/bulletins/affichage_bulletin");

	}

	@RequestMapping(method = RequestMethod.GET, path = "/affichage_bulletin")
	public ModelAndView listBulletin() {
		ModelAndView mv = new ModelAndView();
		// Ajout d'une liste pour afficher dans la page html "affichage_bulletin" le
		// calcul des salaires bruts et nets
		List<BulletinSalaire> listeBulletinSalaireBrutNet = bulletinSalaireRepository.findAll();
		for (BulletinSalaire bulletinSalaire : listeBulletinSalaireBrutNet) {
			bulletinSalaire.setResultatCalculRemuneration(calculerRemunerationServicesimple.calculer(bulletinSalaire));

		}

		mv.setViewName("bulletins/affichage_bulletin");
		mv.addObject("bulletins", bulletinSalaireRepository.findAll());
		return mv;
	}

}
