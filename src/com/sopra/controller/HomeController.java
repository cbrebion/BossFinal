package com.sopra.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.IAdminDAO;
import com.sopra.model.Admin;

@Controller
public class HomeController {
	
	private static final String ATT_ADMIN	= "admin";
	private static final String ATT_ERREUR	= "erreur";
	
	@Autowired
	private IAdminDAO adminHibernateDAO;

	/**
	 * PAGE ACCUEIL
	 * @return
	 */
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	/**
	 * CONNEXION
	 * @param a
	 * @param result
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public String home(@Valid @ModelAttribute("admin") Admin a,
						BindingResult result,
						HttpSession session,
						Model model) {
		
		if (result.hasErrors()) {
			return "home";
		}
		
		Admin admin = adminHibernateDAO.findByUsername(a.getPseudo());
		
		if (admin != null) {
			if (admin.getMdp().equals(a.getMdp())) {
				session.setAttribute(ATT_ADMIN, admin);
				
				return "redirect:/affichageTests";
			}
			// MDP incorrect
			else {
				model.addAttribute(ATT_ERREUR, "Mot de passe incorrect");
				return "home";
			}
		}
		// Non inscrit
		else {
			model.addAttribute(ATT_ERREUR, "Vous n'êtes pas inscrit");
			return "home";
		}
	}
	
	@ModelAttribute("admin")
	public Admin initAdmin() {
		Admin admin = new Admin();
		
		return admin;
	}
}
