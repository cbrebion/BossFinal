package com.sopra.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.ICandidatTestDAO;
import com.sopra.model.CandidatTest;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/candidattest")
public class CandidatTestRestController {
	@Autowired
	private ICandidatTestDAO candidatTestHibernateDAO;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CandidatTest> getByCode(@RequestParam(value="code", required=true) String code) {
		return new ResponseEntity<CandidatTest>(this.candidatTestHibernateDAO.findByCode(code), HttpStatus.OK);
	}

	
	// login d'un candidat
	@RequestMapping(value="/connexion", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CandidatTest> login(@RequestBody CandidatTest candidatTest) {
		
		
		
		candidatTest = candidatTestHibernateDAO.findByCode(candidatTest.getCode());
			
		if(candidatTest==null) {
			return new ResponseEntity<CandidatTest>(HttpStatus.FORBIDDEN);
		}
		else
		{
			return new ResponseEntity<CandidatTest>(candidatTest, HttpStatus.OK);
		}
	}
	
	
}
