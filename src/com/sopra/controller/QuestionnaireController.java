package com.sopra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.IQuestionnaireDAO;
import com.sopra.model.Questionnaire;

@Controller
public class QuestionnaireController {

	// Injection des DAO
	@Autowired private IQuestionnaireDAO questionnaireDAO;
	
	
	
	
	// LISTING
		// Affichage des questionnaires
		@RequestMapping(value="/affichageQuestionnaire", method=RequestMethod.GET)
		public String afficherQuestionnaire(Model model
											) {
			model.addAttribute("Questionnaires", questionnaireDAO.findAll());
			return "affichageQuestionnaire";
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
