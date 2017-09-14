package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.ITestDAO;
import com.sopra.model.Test;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/test")
public class TestRestController {
	@Autowired
	private ITestDAO testHibernateDAO;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Test>> getAll() {
		return new ResponseEntity<List<Test>>(this.testHibernateDAO.findAll(), HttpStatus.OK);
	}

}
