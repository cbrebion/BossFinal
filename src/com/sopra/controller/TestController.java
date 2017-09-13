package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.ITestDAO;
import com.sopra.model.Test;

@Controller
public class TestController {
	
	//Récupération de la DAO
	
	@Autowired
	private ITestDAO testDAO;
	
	
	//récupération de la liste des tests l'afficher
	
	@RequestMapping(value="/test/add", method=RequestMethod.GET)
	public String creationTest(Model model) {

		return "creationTest";
	}
	
	@ModelAttribute("test")
	public Test initTest() {
		Test test = new Test();
		return test;
	}
	
	@RequestMapping(value="/affichageTests", method=RequestMethod.GET)
	public String getListeTest(Model model) {
		model.addAttribute("affichageTests", testDAO.findAll());

		return "affichageTests";
	}
	
	//Création d'un test
	
	@RequestMapping(value="/test/add", method=RequestMethod.POST)
	public String creationTest(@ModelAttribute("test") Test test, 
			BindingResult result) {

		testDAO.save(test);
		return "redirect:/affichageTests";

	}
	
	
	
}
