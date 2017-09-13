package com.sopra.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class CandidatTest implements Serializable {

	
	// Attributs
	@Id
	@Column(name="CDT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name="CDT_CODE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String code;
	
	@ManyToOne
	@JoinColumn(name="CDT_TEST")
	protected Test test;
	
	@ManyToOne
	@JoinColumn(name="CDT_CANDIDAT")
	protected Candidat candidat;
	
	@OneToMany(mappedBy="candidatTest")
	protected List<Reponse> reponses;
	
	
	
	// Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

}
