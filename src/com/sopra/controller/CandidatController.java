package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.ICandidatDAO;
import com.sopra.model.Candidat;

@Controller
public class CandidatController {
	
	//Récupération de la DAO
	
	@Autowired
	private ICandidatDAO candidatDAO;
	
	
	//récupération de la liste des tests l'afficher
	
	@RequestMapping(value="/candidat/add", method=RequestMethod.GET)
	public String ajoutCandidat(Model model) {

		return "ajoutCandidat";
	}
	
	@ModelAttribute("candidat")
	public Candidat initCandidat() {
		Candidat candidat = new Candidat();
		return candidat;
	}
	
	@RequestMapping(value="/affichageCandidats", method=RequestMethod.GET)
	public String getListeCandidat(Model model) {
		model.addAttribute("affichageCandidats", candidatDAO.findAll());

		return "affichageCandidatss";
	}
	
	//Création d'un test
	
	@RequestMapping(value="/candidat/add", method=RequestMethod.POST)
	public String creationCandidat(@ModelAttribute("candidat") Candidat candidat, 
			BindingResult result) {

		candidatDAO.save(candidat);
		return "redirect:/affichageCandidats";

	}
	
	
	
}