package dev.paie.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer_employe")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("entreprises", entrepriseRepository.findAll());
		mv.addObject("profils", profilRemunerationRepository.findAll());
		mv.addObject("grades", gradeRepository.findAll());
		mv.setViewName("employes/creer_employe");
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer_employe")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Entreprise entreprise = entrepriseRepository.findOne(new Integer(request.getParameter("entrepriseId")));
		ProfilRemuneration profilRemuneration = profilRemunerationRepository
				.findOne(new Integer(request.getParameter("profilId")));
		Grade grade = gradeRepository.findOne(new Integer(request.getParameter("gradeId")));
		String matricule = request.getParameter("Matricule");

		RemunerationEmploye remunerationEmploye = new RemunerationEmploye(matricule, entreprise, profilRemuneration,
				grade);
		// System.out.println(remunerationEmploye);
		remunerationEmployeRepository.save(remunerationEmploye);
		
		return new ModelAndView("redirect:"+"/mvc/employes/affichage_employe");
		
	}

	@RequestMapping(method = RequestMethod.GET, path = "/affichage_employe")
	public ModelAndView listEmploye() {
		ModelAndView mv = new ModelAndView();
	
	mv.setViewName("employes/affichage_employe");
	mv.addObject("employes", remunerationEmployeRepository.findAll());
	return mv;
	}
	
	
	
	
	
}