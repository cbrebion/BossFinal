package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sopra.dao.IQuestionDAO;

@Controller
public class QuestionController {
	
	@Autowired
	private IQuestionDAO questionHibernateDAO;
	
	@RequestMapping(value="")

}
