package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sopra.dao.IReponseDAO;
import com.sopra.model.Reponse;

@Controller
@CrossOrigin("*")
@RequestMapping("/reponse")
public class ReponseRestController {

	@Autowired
	private IReponseDAO reponseHibernateDAO;
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Reponse> add(@RequestBody Reponse reponse) {
		System.out.println(reponse.toString());
		System.out.println(reponse.getCandidatTest());
		System.out.println(reponse.getProposition());
		//reponse = reponseHibernateDAO.save(reponse);
		return new ResponseEntity<Reponse>(reponse, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Reponse>> getAll() {
		return new ResponseEntity<List<Reponse>>(this.reponseHibernateDAO.findAll(), HttpStatus.OK);
	}
}
