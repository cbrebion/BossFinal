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
	
	@Autowired
	private IQuestionDAO questionHibernateDAO;
	
	@Autowired
	private IQuestionnaireDAO questionnaireHibernateDAO;
	
	@RequestMapping(value="/{idQuestionnaire}/questions", method = RequestMethod.GET)
	public String question(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
							Model model) {
		
		Questionnaire quest = questionnaireHibernateDAO.find(idQuestionnaire);
		List<Question> questions = quest.getQuestions();
		
		model.addAttribute(ATT_QUESTIONS, questions);
		
		return idQuestionnaire + "/questions";
	}
	
	
	@RequestMapping(value="/{idQuestionnaire}/modifier/{idQuestion}", method = RequestMethod.GET)
	public String modifierQuestion(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
									@PathVariable(value="idQuestion", required=true) int idQuestion,
									Model model) {
		
		Question question = questionHibernateDAO.find(idQuestion);
		model.addAttribute(ATT_QUESTION, question);
		
		return idQuestionnaire + "/modifierQuestion/" + idQuestion;
	}
	
	
	@RequestMapping(value="/{idQuestionnaire}/modifier/{idQuestion}", method = RequestMethod.POST)
	public String modifierQuestion(@PathVariable(value="idQuestionnaire", required=true) int idQuestionnaire,
									@PathVariable(value="idQuestion", required=true) int idQuestion,
									@Valid @ModelAttribute("question") Question q,
									BindingResult result,
									Model model) {
		
		return "redirect:/" + idQuestionnaire + "/questions";
	}
	

}
