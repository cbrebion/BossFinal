package com.sopra.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sopra.dao.IPropositionDAO;
import com.sopra.model.Proposition;

@Controller
@Aspect
public class PropositionAspect {
	@Autowired 
	private IPropositionDAO propositionDAO;
	
	@Before("execution(public com.sopra.dao.hibernate.PropositionDAO(..)) && args(proposition)")
	public void modificationBonneReponse(Proposition proposition) {
		
	}

}
