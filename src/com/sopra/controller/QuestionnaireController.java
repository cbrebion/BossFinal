package com.sopra.controller;

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
			System.out.println(test.getId());
			model.addAttribute("Test", test);
			model.addAttribute("QuestionnairesTest", test.getQuestionnaires());
			
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
		
		// Process d'ajout de questionnaire
		@RequestMapping(value="/processAjoutQuestionnaire", method=RequestMethod.POST)
		public String processAjoutQuestionnaire(@Valid @ModelAttribute("nouveauQuestionnaire") Questionnaire nouveauQuestionnaire,
												BindingResult result,
												Model model
												) {
		/*new AjouterQuestionnaireValidateur().validate(nouveauQuestionnaire, result);
			if(result.hasErrors()) {
				return "ajoutQuestionnaire";
			}*/
		questionnaireDAO.save(nouveauQuestionnaire);
		return "redirect:/affichageQuestionnaire";
		}
					
}
