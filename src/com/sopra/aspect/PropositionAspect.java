package com.sopra.aspect;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sopra.dao.IPropositionDAO;
import com.sopra.model.Proposition;
import com.sopra.model.Question;

@Controller
@Aspect
public class PropositionAspect {
	@Autowired 
	private IPropositionDAO propositionDAO;
	
	@Before("execution(* com.sopra.dao.hibernate.PropositionHibernateDAO.save(..)) && args(proposition)")
	public void modificationBonneReponse(Proposition proposition) {
		//on r�cup�re la question associ�e � la proposition qui va �tre sauvegard�e dans la bdd
		Question question = proposition.getQuestion();
		//on r�cup�re la liste des propositions associ�es � la question
		List<Proposition> propositions = question.getPropositions();
		
		if(proposition.isCorrect()) {
			for(Proposition prop : propositions) {
				if(prop.isCorrect()) {
					prop.setCorrect(false);
					prop = propositionDAO.save(prop);
				}
			}
		}
		
		
	}

}
