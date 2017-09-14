package com.sopra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.IQuestionnaireDAO;
import com.sopra.dao.ITestDAO;
import com.sopra.model.Questionnaire;
import com.sopra.model.Test;

@Controller
public class QuestionnaireController {

	// Injection des DAO
	@Autowired private IQuestionnaireDAO questionnaireDAO;
	@Autowired private ITestDAO testDAO;
	
	
	
	
	// LISTING
		// Affichage des questionnaires
		@RequestMapping(value="/questionnaires", method=RequestMethod.GET)
		public String afficherQuestionnaires(Model model
											) {
			model.addAttribute("Questionnaires", questionnaireDAO.findAll());
			return "affichageQuestionnaires";
		}
		
		
		// Affichage des questionnaires d'un test
		@RequestMapping(value="/test-{id}/questionnaires", method=RequestMethod.GET)
		public String afficherQuestionnairesTest(	@PathVariable(value="id", required=true) Integer id,
													Model model
													) {
			Test test = testDAO.find(id);
			model.addAttribute("Test", test);
			model.addAttribute("QuestionnairesTest", questionnaireDAO.findAll());
			
			return "affichageQuestionnairesTest";
		}
	
	
		
	// AJOUT
		// Page d'ajout de questionnaire
		@RequestMapping(value="/ajoutQuestionnaire", method=RequestMethod.GET)
		public String ajouterQuestionnaire(	Model model
											) {
			model.addAttribute("nouveauQuestionnaire", new Questionnaire());
			return "ajoutQuestionnaire";
		}
		
		
		
	// ASSOCIATION & DISSOCIATION
		// Page d'association de questionnaire et de test
		@RequestMapping(value="test-{idT}/associer/{idQ}", method=RequestMethod.GET)
		public String associerQuestionnaireTest(@PathVariable(value="idT", required=true) Integer idT,
												@PathVariable(value="idQ", required=true) Integer idQ,
												Model model
												) {
			Questionnaire questionnaire = questionnaireDAO.find(idQ);
			Test test = testDAO.find(idT);
			
			/*
			List<Questionnaire> questionnairesTest = test.getQuestionnaires();
			questionnairesTest.add(questionnaire);
			test.setQuestionnaires(questionnairesTest);
			*/
			
			
			questionnaire.getTests().add(test);
			
			
			//testDAO.save(test);
			questionnaireDAO.save(questionnaire);
			
			return "redirect:/test-{idT}/questionnaires";
		}
		
		// Page de dissociation de questionnaire et de test
		@RequestMapping(value="test-{idT}/dissocier/{idQ}", method=RequestMethod.GET)
		public String dissocierQuestionnaireTest(@PathVariable(value="idT", required=true) Integer idT,
												@PathVariable(value="idQ", required=true) Integer idQ,
												Model model
												) {
			Questionnaire questionnaire = questionnaireDAO.find(idQ);
			Test test = testDAO.find(idT);
			questionnaire.getTests().remove(test);
			
			questionnaireDAO.save(questionnaire);
			
			return "redirect:/test-{idT}/questionnaires";
		}
		
		
		
		// Process d'ajout de questionnaire
		@RequestMapping(value="/processAjoutQuestionnaire", method=RequestMethod.POST)
		public String processAjoutQuestionnaire(@Valid @ModelAttribute("nouveauQuestionnaire") Questionnaire nouveauQuestionnaire,
												BindingResult result,
												Model model
												) {
		questionnaireDAO.save(nouveauQuestionnaire);
		return "redirect:/affichageQuestionnaire";
		}
					
}
