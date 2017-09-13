package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.sopra.dao.ITestDAO;

@Controller
public class TestController {
	
	//Récupération de la DAO
	@Autowired
	private ITestDAO testDAO;
	
	//récupération de la liste des tests l'afficher 
	
	public String afficherTest(Model model) {
	
	}
	
	
	
}
