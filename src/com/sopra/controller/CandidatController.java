package com.sopra.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.ICandidatDAO;
import com.sopra.dao.ICandidatTestDAO;
import com.sopra.dao.ITestDAO;
import com.sopra.model.Candidat;
import com.sopra.model.CandidatTest;
import com.sopra.model.Test;

@Controller
public class CandidatController {
	
	//Récupération de la DAO
	
	@Autowired
	private ICandidatDAO candidatDAO;
	
	@Autowired 
	private ICandidatTestDAO candidatTestDAO;
	
	@Autowired
	private ITestDAO testDAO;
	
	
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

		return "affichageCandidats";
	}
	
	//Création d'un test
	
	@RequestMapping(value="/candidat/add", method=RequestMethod.POST)
	public String creationCandidat(@ModelAttribute("candidat") Candidat candidat, 
			BindingResult result) {

		candidatDAO.save(candidat);
		return "redirect:/affichageCandidats";

	}
	
	//récupération du candidat pour créer un candidat Test 
	@RequestMapping(value="{idCandidat}/ajouterTest", method=RequestMethod.GET)
	public String candidatTest(@PathVariable Integer idCandidat, Model model) {
		
		//récupération du candidat
		Candidat candidat = candidatDAO.find(idCandidat);

		//on met le candidatTest en model attribut
		model.addAttribute("candidat", candidat);
		
		//on met aussi en modelAttribut la liste de Test disponible
		List<Test> tests = testDAO.findAll();
		model.addAttribute("listeTests", tests);
		
		return "ajoutCandidatTest";
	}
	
	@RequestMapping(value="{idCandidat}/associerTest/{idTest}", method=RequestMethod.GET)
	public String creationCandidatTest(@PathVariable Integer idCandidat, @PathVariable Integer idTest, Model model) {
		//récupération du candidat
		Candidat candidat = candidatDAO.find(idCandidat);
		//récupération du test
		Test test = testDAO.find(idTest);
		
		//creation d'un candidat test auquel on set le candidat récupéré ci dessus
		CandidatTest candidatTest = new CandidatTest();
		
		
		//création du code aléatoire et unique sur 6 chiffres
		String code = UUID.randomUUID().toString().substring(0, 6);

		candidatTest.setCandidat(candidat);
		candidatTest.setCode(code);
		candidatTest.setTest(test);
		
		//sauvegarde du candidat test en Bdd
		candidatTestDAO.save(candidatTest);
		
		return "redirect:/{idCandidat}/ajouterTest";
	}
	
}