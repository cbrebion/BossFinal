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
		//on récupère la question associée à la proposition qui va être sauvegardée dans la bdd
		Question question = proposition.getQuestion();
		//on récupère la liste des propositions associées à la question
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
