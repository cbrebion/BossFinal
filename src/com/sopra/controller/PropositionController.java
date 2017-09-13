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

import com.sopra.dao.IPropositionDAO;
import com.sopra.dao.IQuestionDAO;
import com.sopra.model.Proposition;
import com.sopra.model.Question;

@Controller
public class PropositionController {

	@Autowired
	private IPropositionDAO propositionDAO;
	@Autowired 
	private IQuestionDAO questionDAO;
	
	
	//méthode pour afficher la liste des propositions
	@RequestMapping(value="/{id}/propositions", method=RequestMethod.GET)
	public String affichageProposition(@PathVariable Integer id, Model model) {
		Question question = questionDAO.find(id);
		model.addAttribute("listePropositions", question.getPropositions());
		model.addAttribute("question", question);
		return "affichageProposition";
	}
	
	//ajout d'une proposition 
	@RequestMapping(value="/{id}/propositions/ajouter", method=RequestMethod.GET)
	public String afficherAjoutProposition(@PathVariable Integer id, Model model) {
		Question question = questionDAO.find(id);
		model.addAttribute("newProposition", new Proposition());
		model.addAttribute("question", question);
		return "ajoutProposition";
	}
	
	@RequestMapping(value="/{idQuestion}/propositions/ajouter", method=RequestMethod.POST)
	public String ajoutProposition(@PathVariable Integer idQuestion, @Valid @ModelAttribute("newProposition") Proposition newProposition, BindingResult result, Model model) {
		Question question = questionDAO.find(idQuestion);
		newProposition.setQuestion(question);
		
		if(result.hasErrors()) {
			return "ajoutProposition";
		}
		
		propositionDAO.save(newProposition);
		return "redirect:/{idQuestion}/propositions";
	}
	
	
	//suppression d'une proposition
	@RequestMapping(value="/{idQuestion}/propositions/{idProposition}/supprimer", method=RequestMethod.GET)
	public String suppressionProposition(@PathVariable Integer idQuestion, @PathVariable Integer idProposition) {
		propositionDAO.delete(propositionDAO.find(idProposition));
		return "redirect:/{idQuestion}/propositions";
	}
	
	//modification d'une proposition 
}
