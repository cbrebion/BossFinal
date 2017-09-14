package com.sopra.aspect;

import java.util.UUID;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sopra.dao.ICandidatTestDAO;
import com.sopra.model.CandidatTest;

@Controller
@Aspect
public class GenerationCodeAspect {
	@Autowired
	private ICandidatTestDAO candidatTestDAO;

	@Before("execution(* com.sopra.dao.hibernate.CandidatTestHibernateDAO.save(..)) && args(candidatTest)")
	public void generationCode(CandidatTest candidatTest) {

		if(candidatTest.getCode() == null) {
			//création du code aléatoire et unique sur 6 chiffres
			String code = UUID.randomUUID().toString().substring(0, 6);

			candidatTest.setCode(code);
		}
	}
}
