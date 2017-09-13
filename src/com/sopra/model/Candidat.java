package com.sopra.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="candidat")
@PrimaryKeyJoinColumn(name="CAN_ID", referencedColumnName="PER_ID")
public class Candidat extends Personne {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@OneToMany(mappedBy="candidat")
	protected List<CandidatTest> candidatTests;



	// Getters & Setters
	public List<CandidatTest> getCandidatTests() {
		return candidatTests;
	}

	public void setCandidatTests(List<CandidatTest> candidatTests) {
		this.candidatTests = candidatTests;
	}
}
