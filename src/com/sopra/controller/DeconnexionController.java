package com.sopra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DeconnexionController {

	@RequestMapping(value="/deconnexion", method = RequestMethod.GET)
	public String disconnect(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

}
