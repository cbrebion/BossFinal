package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="reponse")
public class Reponse {
	
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REP_ID")
	protected Integer id;

	
	@ManyToOne
	@JoinColumn(name="REP_PROPOSITION")
	protected Proposition proposition;
	
	
	@ManyToOne
	@JoinColumn(name="REP_CANDIDATTEST")
	protected CandidatTest candidatTest;

	
	
	// Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	@JsonIgnore
	public CandidatTest getCandidatTest() {
		return candidatTest;
	}

	@JsonProperty("candidatTest")
	public void setCandidatTest(CandidatTest candidatTest) {
		this.candidatTest = candidatTest;
	}
}
