package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sopra.dao.IPropositionDAO;
import com.sopra.dao.IReponseDAO;
import com.sopra.model.Proposition;
import com.sopra.model.Reponse;

@Controller
@CrossOrigin("*")
@RequestMapping("/reponse")
public class ReponseRestController {

	@Autowired private IReponseDAO reponseHibernateDAO;
	@Autowired private IPropositionDAO propositionHibernateDAO;
	@Autowired private SimpMessageSendingOperations operationsDEnvoi;

	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Reponse> add(@RequestBody Reponse reponse) {
		reponse = reponseHibernateDAO.save(reponse);
		
		
		// WEBSOCKET
			Integer candidatId = reponse.getCandidatTest().getCandidat().getId();
	
			// On affecte la phrase de statut bonne/mauvaise réponse
			String statut;
			Proposition p = propositionHibernateDAO.find(reponse.getProposition().getId());
			if(p.isCorrect()) {statut = "Bonne réponse";} else {statut = "Mauvaise réponse";}
			
			// On crée l'intitulé de type  "question - réponse - statut"
			String aDemande = p.getQuestion().getLibelle();
			String aRepondu = p.getLibelle();
			String intituleReponse = aDemande+" - "+aRepondu+" - "+statut;
			
			// On envoie l'intitulé dans le canal relatif au candidat
			this.operationsDEnvoi.convertAndSend(String.format("/%s", candidatId), intituleReponse);
		// FIN - WEBSOCKET
		
			
		return new ResponseEntity<Reponse>(reponse, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Reponse>> getAll() {
		return new ResponseEntity<List<Reponse>>(this.reponseHibernateDAO.findAll(), HttpStatus.OK);
	}
}
