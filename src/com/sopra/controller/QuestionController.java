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

import com.sopra.dao.IQuestionDAO;
import com.sopra.dao.IQuestionnaireDAO;
import com.sopra.model.Question;
import com.sopra.model.Questionnaire;

@Controller
public class QuestionController {
	private static final String ATT_QUESTION			= "question";
	private static final String ATT_QUESTIONS			= "questions";
	private static final String ATT_ERREUR				= "erreur";
	
	@Autowired
	private IQuestionDAO questionHibernateDAO;
	
	@Autowired
	private IQuestionnaireDAO questionnaireHibernateDAO;
	
	
	/**
	 * AFFICHAGE DES QUESTIONS D'UN QUESTIONNAIRE
	 * @param idQuestionnaire
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{idQuestionnaire}/questions", method = RequestMethod.GET)
	public String question(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
							Model model) {
		
		Questionnaire quest = questionnaireHibernateDAO.find(idQuestionnaire);
		List<Question> questions = quest.getQuestions();
		
		model.addAttribute(ATT_QUESTIONS, questions);
		
		return "affichageQuestions";
	}
	
	
	/**
	 * MODIFICATION D'UNE QUESTION (GET)
	 * @param idQuestionnaire
	 * @param idQuestion
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{idQuestionnaire}/questions/{idQuestion}/modifier", method = RequestMethod.GET)
	public String modifierQuestion(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
									@PathVariable(value="idQuestion", required=true) int idQuestion,
									Model model) {
		
		Question question = questionHibernateDAO.find(idQuestion);
		model.addAttribute(ATT_QUESTION, question);
		
		return "modifierQuestion";
	}
	
	
	
	/**
	 * MODIFICATION D'UNE QUESTION (POST)
	 * @param idQuestionnaire
	 * @param idQuestion
	 * @param q
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{idQuestionnaire}/questions/{idQuestion}/modifier", method = RequestMethod.POST)
	public String modifierQuestion(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
									@PathVariable(value="idQuestion", required=true) int idQuestion,
									@Valid @ModelAttribute("question") Question q,
									BindingResult result,
									Model model) {
		Question question = questionHibernateDAO.find(idQuestion);
		
		if (result.hasErrors()) {
			model.addAttribute(ATT_QUESTION, question);
			model.addAttribute(ATT_ERREUR, "Erreur dans la modification de la question");
			
			return "modifierQuestion";
		}
		
		question.setLibelle(q.getLibelle());
		
		question = questionHibernateDAO.save(question);

		//return "redirect:/" + idQuestionnaire + "/questions";
		return "redirect:/{idQuestionnaire}/questions";
	}
	
	
	@RequestMapping(value="/{idQuestionnaire}/questions/{idQuestion}/supprimer", method = RequestMethod.GET)
	public String supprimerQuestion(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
									@PathVariable(value="idQuestion", required=true) int idQuestion,
									Model model) {
		Question question = questionHibernateDAO.find(idQuestion);
		
		questionHibernateDAO.delete(question);
		
		return "redirect:/{idQuestionnaire}/questions";
	}

}
