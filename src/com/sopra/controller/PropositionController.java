package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.IPropositionDAO;
import com.sopra.dao.IQuestionDAO;
import com.sopra.model.Question;

@Controller
public class PropositionController {

	@Autowired
	private IPropositionDAO propositionDAO;
	@Autowired 
	private IQuestionDAO questionDAO;
	
	
	//méthode pour afficher la liste des propositions
	@RequestMapping(value="/{id}/props", method=RequestMethod.GET)
	public String affichageProposition(@PathVariable Integer id, Model model) {
		Question question = questionDAO.find(id);
		model.addAttribute("listePropositions", question.getPropositions());
		return "affichageProposition";
	}
	
	//ajout d'une proposition 
	
	
	//suppression d'une proposition
	
	
	//modification d'une proposition 
}
